package Chess.Piece;

import Chess.Board;

public class Rook extends Piece {

    public Rook(int x, int y, boolean white, String filePath, Board board) {
        setX(x);
        setY(y);
        setWhite(white);
        setFilePath(filePath);
        setBoard(board);
    }

    @Override
    public boolean canMove(int finalX, int finalY)
    {
        // rook can only move in straight lines
        // if x and y change, won't allow
        if (this.getX() != finalX && this.getY() != finalY)
            return false;

        // rook cannot move if pieces are blocking
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


        // rook cannot move to spot with own piece
        // potential piece at final destination
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


