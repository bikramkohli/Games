package Chess;

import Chess.Piece.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class Board extends JComponent {

    public int count = 0;

    private final int squareWidth = 65;
    public ArrayList<Piece> whitePieces;
    public ArrayList<Piece> blackPieces;

    public ArrayList<DrawingImage> boardImages;
    public ArrayList<DrawingImage> pieceImages;

    public Piece currPiece;

    public Board() {

        boardImages = new ArrayList();
        pieceImages = new ArrayList();
        whitePieces = new ArrayList();
        blackPieces = new ArrayList();

        addPieces();

        this.setPreferredSize(new Dimension(squareWidth*8, squareWidth*8));
        this.setVisible(true);
        this.addMouseListener(mouseAdapter);

        drawBoard();
    }

    public void addPieces() {

        // adding white pieces to array list
        whitePieces.add(new Rook(0, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteRook.jpeg", this));
        whitePieces.add(new Knight(1, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteKnight.jpeg", this));
        whitePieces.add(new Bishop(2, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteBishop.jpeg", this));
        whitePieces.add(new Queen(3, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteQueen.png", this));
        whitePieces.add(new King(4, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteKing.jpeg", this));
        whitePieces.add(new Bishop(5, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteBishop.jpeg", this));
        whitePieces.add(new Knight(6, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteKnight.jpeg", this));
        whitePieces.add(new Rook(7, 7, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteRook.jpeg", this));

        // white pawns
        whitePieces.add(new Pawn(0, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(1, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(2, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(3, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(4, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(5, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(6, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));
        whitePieces.add(new Pawn(7, 6, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhitePawn.jpeg", this));

        // adding black pieces to array list
        blackPieces.add(new Rook(0, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackRook.jpeg", this));
        blackPieces.add(new Knight(1, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackKnight.png", this));
        blackPieces.add(new Bishop(2, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackBishop.jpeg", this));
        blackPieces.add(new Queen(3, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackQueen.jpeg", this));
        blackPieces.add(new King(4, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackKing.png", this));
        blackPieces.add(new Bishop(5, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackBishop.jpeg", this));
        blackPieces.add(new Knight(6, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackKnight.png", this));
        blackPieces.add(new Rook(7, 0, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackRook.jpeg", this));

        // black pawns
        blackPieces.add(new Pawn(0, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(1, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(2, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(3, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(4, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(5, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(6, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
        blackPieces.add(new Pawn(7, 1, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackPawn.png", this));
    }

    private Image loadImage(String imageFile) {
        try {
            return ImageIO.read(new File(imageFile));
        }
        catch (IOException e) {
            return new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        }
    }

    private void drawBoard() {
        // clearing lists to add for drawing
        pieceImages.clear();
        boardImages.clear();

        // adding image of board
        Image board = loadImage("/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/ChessBoard.png");
        boardImages.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));

        // if piece is selected, add red square to show "highlighted piece"
        if (currPiece != null) {
            Image activeSquare = loadImage("/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/ActiveSquare.png");
            boardImages.add(new DrawingImage(activeSquare, new Rectangle2D.Double
                    (squareWidth*currPiece.getX(),squareWidth*currPiece.getY(), activeSquare.getWidth(null), activeSquare.getHeight(null))));
        }

        // adding white pieces to list
        for (int i = 0; i < whitePieces.size(); i++) {
            int COL = whitePieces.get(i).getX();
            int ROW = whitePieces.get(i).getY();
            Image piece = loadImage(whitePieces.get(i).getFilePath());
            Image resizedPiece = piece.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            pieceImages.add(new DrawingImage(resizedPiece, new Rectangle2D.Double
                    (squareWidth*COL,squareWidth*ROW, resizedPiece.getWidth(null), resizedPiece.getHeight(null))));
        }

        // adding black pieces to list
        for (int i = 0; i < blackPieces.size(); i++) {
            int COL = blackPieces.get(i).getX();
            int ROW = blackPieces.get(i).getY();
            Image piece = loadImage(blackPieces.get(i).getFilePath());
            Image resizedPiece = piece.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            pieceImages.add(new DrawingImage(resizedPiece, new Rectangle2D.Double
                    (squareWidth*COL,squareWidth*ROW, resizedPiece.getWidth(null), resizedPiece.getHeight(null))));
        }

        this.repaint();
    }

    public Piece getPiece(int x, int y) {
        for (Piece p : whitePieces)
        {
            if (p.getX() == x && p.getY() == y)
            {
                return p;
            }
        }
        for (Piece p : blackPieces)
        {
            if (p.getX() == x && p.getY() == y)
            {
                return p;
            }
        }
        return null;
    }

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            int clickedX = e.getX();
            int clickedY = e.getY();
            int clickedRow = clickedY / squareWidth;
            int clickedColumn = clickedX / squareWidth;
            boolean lostWhite = false;
            boolean lostBlack = false;

            boolean whiteTurn = true;

            // check whos turn it is
            if (count%2 == 1)
                whiteTurn = false;

            // getting piece at clicked position
            Piece clickedPiece = getPiece(clickedColumn, clickedRow);

            // if no piece is selected and you select an appropriate color piece
            if (currPiece == null && clickedPiece != null &&
                    ((whiteTurn && clickedPiece.isWhite()) || (!whiteTurn && !clickedPiece.isWhite())))
                currPiece = clickedPiece;

            // if piece is selected and you click the piece again, deselect
            else if (currPiece != null && currPiece.getX() == clickedColumn && currPiece.getY() == clickedRow)
                currPiece = null;

            // if piece is selected and you click different square
            else if (currPiece != null && currPiece.canMove(clickedColumn, clickedRow)
                    && ((whiteTurn && currPiece.isWhite()) || (!whiteTurn && !currPiece.isWhite()))) {
                // if piece is at other square, remove piece
                if (clickedPiece != null) {
                    if (clickedPiece.isWhite()) {
                        whitePieces.remove(clickedPiece);
                        if (clickedPiece.getClass().equals(King.class))
                            lostWhite = true;
                    }


                    else {
                        blackPieces.remove(clickedPiece);
                        if (clickedPiece.getClass().equals(King.class))
                            lostBlack = true;
                    }
                }

                // move selected piece to desired location
                currPiece.setX(clickedColumn);
                currPiece.setY(clickedRow);

                if (lostWhite) {
                    showMessageDialog(currPiece.board, "Black Wins!");
                    setVisible(false);
                }

                if (lostBlack) {
                    showMessageDialog(currPiece.board, "White Wins!");
                    setVisible(false);
                }

                // set pawn hasMoved
                if (currPiece.getClass().equals(Pawn.class)) {
                    Pawn castedPawn = (Pawn)(currPiece);
                    castedPawn.setHasMoved(true);
                }

                // promoting white pawn to queen
                if (currPiece.isWhite() && currPiece.getY() == 0 && currPiece.getClass().equals(Pawn.class)) {
                    int xCoord = currPiece.getX();
                    whitePieces.remove(currPiece);
                    whitePieces.add(new Queen(xCoord, 0, true, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/WhiteQueen.png", currPiece.board));
                }

                // promoting white pawn to queen
                if (!currPiece.isWhite() && currPiece.getY() == 7 && currPiece.getClass().equals(Pawn.class)) {
                    int xCoord = currPiece.getX();
                    blackPieces.remove(currPiece);
                    blackPieces.add(new Queen(xCoord, 7, false, "/Users/bikramkohli/IdeaProjects/GameProjects/src/Chess/Piece/BlackQueen.jpeg", currPiece.board));
                }

                currPiece = null;
                count++;
            }

            drawBoard();
        }
    };

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        drawAll(g2);
    }

    private void drawAll(Graphics2D g2) {
        for (DrawingImage shape : boardImages) {
            shape.draw(g2);
        }
        for (DrawingImage shape : pieceImages) {
            shape.draw(g2);
        }
    }
}

class DrawingImage {

    public Image image;
    public Rectangle2D rect;

    public DrawingImage (Image image, Rectangle2D rect) {
        this.image = image;
        this.rect = rect;
    }

    public void draw(Graphics2D g2) {
        Rectangle2D bounds = rect.getBounds2D();
        g2.drawImage(image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(),
                0, 0, image.getWidth(null), image.getHeight(null), null);
    }

}