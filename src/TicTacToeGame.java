import javax.swing.*;

public class TicTacToeGame {
    private static String[][] board = new String[3][3];

    static void clearBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    public static void updateGame(String player, int row, int col) {
        board[row][col] = player;
    }

    private static boolean isDiagnalWin(String player) {
        return (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player)) ||
                (board[0][2].equals(player) &&
                        board[1][1].equals(player) &&
                        board[2][0].equals(player));
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player)) {
                return true;
            }
        }
        return false; // no row win
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player)) {
                return true;
            }
        }
        return false; // no col win
    }

    static boolean checkTie() {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X")) {
                xFlag = true; // there is an X in this row
            }
            if (board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O")) {
                oFlag = true; // there is an O in this row
            }

            if (!(xFlag && oFlag)) {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X")) {
                xFlag = true; // there is an X in this col
            }
            if (board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O")) {
                oFlag = true; // there is an O in this col
            }

            if (!(xFlag && oFlag)) {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if (board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X")) {
            xFlag = true;
        }
        if (board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if (board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X")) {
            xFlag = true;
        }
        if (board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false; // No tie can still have a diag win
        }
        // Checked every vector so I know I have a tie
        return true;
    }
    public static boolean checkWin(String player) {
        if (isRowWin(player) || isColWin(player) || isDiagnalWin(player)) {
            return true;
        }
        return false;
    }
}