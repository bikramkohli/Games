package Chess.Piece;

import Chess.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean white, String filePath, Board board) {
        setX(x);
        setY(y);
        setWhite(white);
        setFilePath(filePath);
        setBoard(board);
    }

    // bishop at location (3, 2) in an 8x8 grid going from (0, 0) (7,7)
    // can you move to (4, 5)

    @Override
    public boolean canMove(int finalX, int finalY) {
        // bishop can only move in diagonals
        int xDistance = Math.abs(this.getX() - finalX);
        int yDistance = Math.abs(this.getY() - finalY);
        if (xDistance != yDistance)
            return false;

        // bishop cannot move if pieces are blocking it
        // checking NW travel
        if (this.getX() > finalX && this.getY() > finalY) {
            for (int i = 1; i < xDistance; i++) {
                Piece potentialPiece = board.getPiece(this.getX() - i, this.getY() - i);
                if (potentialPiece != null)
                    return false;
            }
        }

        // checking NE travel
        if (this.getX() < finalX && this.getY() > finalY) {
            for (int i = 1; i < xDistance; i++) {
                Piece potentialPiece = board.getPiece(this.getX() + i, this.getY() - i);
                if (potentialPiece != null)
                    return false;
            }
        }

        // checking SW travel
        if (this.getX() > finalX && this.getY() < finalY) {
            for (int i = 1; i < xDistance; i++) {
                Piece potentialPiece = board.getPiece(this.getX() - i, this.getY() + i);
                if (potentialPiece != null)
                    return false;
            }
        }

        // checking SE travel
        if (this.getX() < finalX && this.getY() < finalY) {
            for (int i = 1; i < xDistance; i++) {
                Piece potentialPiece = board.getPiece(this.getX() + i, this.getY() + i);
                if (potentialPiece != null)
                    return false;
            }
        }



        // bishop cannot move to spot with own piece
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