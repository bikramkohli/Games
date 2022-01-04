package Chess.Piece;

import Chess.Board;

public class Queen extends Piece {

    public Queen(int x, int y, boolean white, String filePath, Board board) {
        setX(x);
        setY(y);
        setWhite(white);
        setFilePath(filePath);
        setBoard(board);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        // queen can move in cardinal direction or in diagonal
        int xDistance = Math.abs(this.getX()-finalX);
        int yDistance = Math.abs(this.getY()-finalY);

        if (this.getX() != finalX && this.getY() != finalY && xDistance != yDistance)
            return false;

        // checking if cardinal direction or diagonal
        String direction = "";
        if (this.getX() == finalX || this.getY() == finalY)
            direction = "Straight";
        else
            direction = "Diagonal";

        // queen cannot move if pieces are blocking
        if (direction == "Straight") {
            // checking right
            if (this.getX() < finalX) {
                int distance = Math.abs(finalX - this.getX());
                for (int i=1; i<distance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX() + i, this.getY());
                    // if piece in path, won't allow
                    if (potentialPiece != null)
                        return false;
                }
            }

            // checking left
            if (this.getX() > finalX) {
                int distance = Math.abs(finalX - this.getX());
                for (int i=1; i<distance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX() - i, this.getY());
                    // if piece in path, won't allow
                    if (potentialPiece != null)
                        return false;
                }
            }

            // checking up
            if (this.getY() > finalY) {
                int distance = Math.abs(finalY - this.getY());
                for (int i=1; i<distance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX(), this.getY() - i);
                    // if piece in path, won't allow
                    if (potentialPiece != null)
                        return false;
                }
            }

            // checking down
            if (this.getY() < finalY) {
                int distance = Math.abs(finalY - this.getY());
                for (int i=1; i<distance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX(), this.getY() + i);
                    if (potentialPiece != null)
                        return false;
                }
            }
        }

        // queen cannot move if pieces are blocking
        if (direction == "Diagonal") {
            // checking NW travel
            if (this.getX() > finalX && this.getY() > finalY) {
                for (int i=1; i<xDistance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX()-i, this.getY()-i);
                    if (potentialPiece != null)
                        return false;
                }
            }

            // checking NE travel
            if (this.getX() < finalX && this.getY() > finalY) {
                for (int i=1; i<xDistance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX()+i, this.getY()-i);
                    if (potentialPiece != null)
                        return false;
                }
            }

            // checking SW travel
            if (this.getX() > finalX && this.getY() < finalY) {
                for (int i=1; i<xDistance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX()-i, this.getY()+i);
                    if (potentialPiece != null)
                        return false;
                }
            }

            // checking SE travel
            if (this.getX() < finalX && this.getY() < finalY) {
                for (int i=1; i<xDistance; i++) {
                    Piece potentialPiece = board.getPiece(this.getX()+i, this.getY()+i);
                    if (potentialPiece != null)
                        return false;
                }
            }
        }

        // queen cannot move to spot with own piece
        // potential piece at destination
        Piece potentialPiece = board.getPiece(finalX, finalY);

        // if piece exists, if same color, won't allow
        if (potentialPiece != null) {
            if (potentialPiece.isWhite() == this.isWhite())
                return false;
            if (!potentialPiece.isWhite() == !this.isWhite())
                return false;
        }



        return true;
    }
}

