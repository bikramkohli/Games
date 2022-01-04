package Chess.Piece;

import Chess.Board;

public abstract class Piece {
    private int xLoc;
    private int yLoc;
    private boolean white;
    private String filePath;
    public Board board;

    public boolean isWhite()
    {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public void setX(int x)
    {
        this.xLoc = x;
    }

    public void setY(int y)
    {
        this.yLoc = y;
    }

    public int getX()
    {
        return xLoc;
    }

    public int getY()
    {
        return yLoc;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String path)
    {
        this.filePath = path;
    }

    public abstract boolean canMove(int destination_x, int destination_y);

    public String toString() {
        return "This piece is a " + this.getClass() + ", column: " + this.getX() + ", row: " + this.getY();
    }
}