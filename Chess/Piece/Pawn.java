package Chess.Piece;

import Chess.Board;

public class Pawn extends Piece {

    private boolean hasMoved = false;

    public Pawn(int x, int y, boolean white, String filePath, Board board) {
        setX(x);
        setY(y);
        setWhite(white);
        setFilePath(filePath);
        setBoard(board);
    }

    public void setHasMoved(boolean hasMoved)
    {
        this.hasMoved = hasMoved;
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        // General pawn movement: pawn can move 1 square vertically, 2 squares vertically, or up 1 side 1
        int xDistance = Math.abs(this.getX() - finalX);
        int yDistance = Math.abs(this.getY() - finalY);

        if (xDistance > 1 || yDistance > 2)
            return false;

        if (xDistance == 1 && yDistance != 1)
            return false;

        if (hasMoved && yDistance > 1)
            return false;

        // potential piece at final destination
        Piece potentialPiece = board.getPiece(finalX, finalY);

        // Checking if pawn is moving up or down
        String direction = "";

        if (this.getY() > finalY)
            direction = "up";
        else
            direction = "down";

        // Valid moves going up
        if (direction == "up") {
            if (!this.isWhite())
                return false;
            if (potentialPiece == null && xDistance != 0)
                return false;
            if (xDistance != 1) {
                if (board.getPiece(this.getX(), this.getY()-1) != null)
                    return false;
                if (board.getPiece(this.getX(), this.getY()-2) != null && yDistance == 2)
                    return false;
            }
        }

        // Valid moves going down
        if (direction == "down") {
            if (this.isWhite())
                return false;
            if (potentialPiece == null && xDistance != 0)
                return false;
            if (xDistance != 1) {
                if (board.getPiece(this.getX(), this.getY()+1) != null)
                    return false;
                if (board.getPiece(this.getX(), this.getY()+2) != null && yDistance == 2)
                    return false;
            }
        }

        // pawn cannot move to spot with own piece
        // if piece exists, if same color, won't allow
        if (potentialPiece != null) {
            if (potentialPiece.isWhite() == this.isWhite())
                return false;
            if (!potentialPiece.isWhite() == !this.isWhite())
                return false;
        }

        setHasMoved(true);
        return true;
    }
}
