package Chess.Piece;

import Chess.Board;

public class Knight extends Piece {

    public Knight(int x, int y, boolean white, String filePath, Board board) {
        setX(x);
        setY(y);
        setWhite(white);
        setFilePath(filePath);
        setBoard(board);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {

        // knight cannot move to spot with own piece
        // potential piece at destination
        Piece potentialPiece = board.getPiece(finalX, finalY);

        // if piece exists, if same color, won't allow
        if (potentialPiece != null) {
            if (potentialPiece.isWhite() == this.isWhite())
                return false;
            if (!potentialPiece.isWhite() == !this.isWhite())
                return false;
        }

        // knight has to move 2 squares in a cardinal direction followed by 1 square perpendicular
        int xDistance = Math.abs(this.getX()-finalX);
        int yDistance = Math.abs(this.getY()-finalY);
        if (xDistance == 2 && yDistance == 1)
            return true;
        else if (xDistance == 1 && yDistance == 2)
            return true;

        // knight can jump over pieces so no other checks

        return false;


    }
}