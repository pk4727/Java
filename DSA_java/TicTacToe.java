import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
         ttt.ticTocToe();
        ttt.ticTocToeN();
    }

    public void Display(char[][] board) {
        for (char[] i : board) {
            for (char j : i) {
                System.out.print(j + " | ");
            }
            System.out.println();
        }
    }

    public void ticTocToeN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size in odd : ");
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean isGameOver = false;
        while (!isGameOver) {
            Display(board);
            System.out.print("Enter your choose(row _ column) ' " + player + " ' : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                isGameOver = isWonN(board, player);
                if (isGameOver) {
                    System.out.println(player + " is won !");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move try again !! ");
            }
        }
        Display(board);
        sc.close();
    }

    public boolean isWonN(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) { // check in column
            int col = 0;
            boolean x = false;
            while (col != board.length) {
                x = board[row][col] == player;
                if (!x) {
                    break;
                }
                col++;
            }
            if (x) {
                return true;
            }
        }

        boolean yx = false;
        for (int col = 0; col < board.length; col++) { // check in column
            int row = 0;
            while (row != board.length) {
                yx = board[row][col] == player;
                if (!yx) {
                    break;
                }
                row++;
            }
            if (yx) {
                return true;
            }
        }

        int col1 = 0; // check in diagonal \
        boolean xx = false;
        while (col1 != board.length) {
            xx = board[col1][col1] == player;
            if (!xx) {
                break;
            }
            col1++;
        }
        if (xx) {
            return true;
        }

        int col2 = 0; // check in diagonal /
        boolean yy = false;
        while (col2 != board.length) {
            yy = board[board.length - 1 - col2][col2] == player;
            if (!yy) {
                break;
            }
            col2++;
        }
        return yy;
    }

    public void ticTocToe() {
        char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        char player = 'X';
        boolean isGameOver = false;
        Scanner sc = new Scanner(System.in);
        while (!isGameOver) {
            Display(board);
            System.out.print("Enter your choose(row _ column) ' " + player + " ' : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                isGameOver = isWon(board, player);
                if (isGameOver) {
                    System.out.println(player + " is won !");
                } else {
                    // player = (player == 'X') ? 'O' : 'X';
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid move try again !! ");
            }
        }
        Display(board);
        sc.close();
    }

    public boolean isWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) { // check in column
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for (int col = 0; col < board.length; col++) { // check in row
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) { // check in diagonal \
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) { // check in diagonal /
            return true;
        }
        return false;
    }
}
