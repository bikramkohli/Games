import java.util.Scanner;

public class ConnectFourBoard {
    private final static int row = 6;
    private final static int column = 7;
    private static String[][] board = new String[row][column];
    private static int playerMove = 0;

    public static void setBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = "_";
            }
        }
    }

    public static void printBoard() {
        for (int i=0; i<row; i++) {
            System.out.print('\n');
            for (int j=0; j<column; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
        }
    }

    public static boolean checkWin() {
        // horizontal check
        for (int i=0; i<row; i++) {
            for (int j=0; j<column-3; j++) {
                if (board[i][j] == "X" && board[i][j+1] == "X" && board[i][j+2] == "X" && board[i][j+3] == "X")
                    return true;
                if (board[i][j] == "O" && board[i][j+1] == "O" && board[i][j+2] == "O" && board[i][j+3] == "O")
                    return true;
            }
        }

        // vertical check
        for (int j=0; j<column; j++) {
            for (int i=0; i<row-3; i++) {
                if (board[i][j] == "X" && board[i+1][j] == "X" && board[i+2][j] == "X" && board[i+3][j] == "X")
                    return true;
                if (board[i][j] == "O" && board[i+1][j] == "O" && board[i+2][j] == "O" && board[i+3][j] == "O")
                    return true;
            }
        }

        // diagonal check descending l->r bottom left half
        for (int rowPos=0; rowPos<row-3; rowPos++) {
            for (int i=rowPos, j=0; i<row-3 ; i++, j++) {
                if (board[i][j] == "X" && board[i+1][j+1] == "X" && board[i+2][j+2] == "X" && board[i+3][j+3] == "X")
                    return true;
                if (board[i][j] == "O" && board[i+1][j+1] == "O" && board[i+2][j+2] == "O" && board[i+3][j+3] == "O")
                    return true;
            }
        }

        // diagonal check descending l->r top right half
        for (int rowPos = row-1; rowPos > row-4; rowPos--) {
            for (int i=rowPos, j=column-1; i>row-4; i--, j--) {
                if (board[i][j] == "X" && board[i-1][j-1] == "X" && board[i-2][j-2] == "X" && board[i-3][j-3] == "X")
                    return true;
                if (board[i][j] == "O" && board[i-1][j-1] == "O" && board[i-2][j-2] == "O" && board[i-3][j-3] == "O")
                    return true;
            }
        }

        // diagonal check ascending l-r top left half
        for (int rowPos=row-1; rowPos>row-4; rowPos--) {
            for (int i = rowPos, j=0; i>row-4; i--, j++) {
                if (board[i][j] == "X" && board[i-1][j+1] == "X" && board[i-2][j+2] == "X" && board[i-3][j+3] == "X")
                    return true;
                if (board[i][j] == "O" && board[i-1][j+1] == "O" && board[i-2][j+2] == "O" && board[i-3][j+3] == "O")
                    return true;
            }
        }

        // diagonal check ascending l-r bottom right half
        for (int rowPos=0; rowPos<row-3; rowPos++) {
            for (int i = rowPos, j=column-1; i<row-3; i++, j--) {
                if (board[i][j] == "X" && board[i+1][j-1] == "X" && board[i+2][j-2] == "X" && board[i+3][j-3] == "X")
                    return true;
                if (board[i][j] == "O" && board[i+1][j-1] == "O" && board[i+2][j-2] == "O" && board[i+3][j-3] == "O")
                    return true;
            }
        }

        return false;
    }

    public static void playMove() {
        printBoard();

        // Getting user move
        String placementPiece = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter column to put piece (1-7)");
        int position = keyboard.nextInt()-1;
        if (position < 0 || position > row) {
            System.out.println("Invalid, enter number 1-7");
                return;
        }

        // Selecting player
        if (playerMove%2 == 0)
            placementPiece = "X";
        else
            placementPiece = "O";

        // Placing piece, also checking validity of column choice
        for (int i = row-1; i>=0; i--) {
            if (board[i][position] == "_") {
                board[i][position] = placementPiece;
                playerMove++;
                break;
            }
            if (row==0)
                System.out.println("Error: column full");
        }
    }

    public static void main(String[] args) {
        setBoard();
        while (checkWin() == false)
            playMove();
        printBoard();
        System.out.print("\n");
        playerMove++;
        System.out.println("Player " + (playerMove%2 + 1) + " wins!");
    }
}
