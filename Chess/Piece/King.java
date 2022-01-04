package Chess.Piece;

import Chess.Board;

public class King extends Piece {

    public King(int x, int y, boolean white, String filePath, Board board) {
        setX(x);
        setY(y);
        setWhite(white);
        setFilePath(filePath);
        setBoard(board);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {

        // king can only move 1 square
        int xDistance = Math.abs(this.getX() - finalX);
        int yDistance = Math.abs(this.getY() - finalY);

        if (xDistance > 1 || yDistance > 1)
            return false;

        // king cannot move to spot with own piece
        // potential piece at final destination
        Piece potentialPiece = board.getPiece(finalX, finalY);

        if (potentialPiece != null) {
            if (this.isWhite() == potentialPiece.isWhite())
                return false;
            if (!this.isWhite() == !potentialPiece.isWhite())
                return false;
        }


        return true;
    }
}