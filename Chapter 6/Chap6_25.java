import java.util.Random;

public class Chap6_25 {
    public static void main(String[] args) {
        Random random = new Random();
        int attempts = 0;

        while (true) {
            attempts++;
            boolean[][] board = new boolean[8][8];
            int queens = 0;

            for (int row = 0; row < 8; row++) {
                int col = random.nextInt(8);
                if (isSafe(row, col, board)) {
                    board[row][col] = true;
                    queens++;
                }
            }

            if (queens == 8) {
                System.out.printf("Found solution via Brute Force on attempt %d:%n", attempts);
                printBoard(board);
                break;
            }
        }
    }

    private static boolean isSafe(int row, int col, boolean[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
            if (col - (row - i) >= 0 && board[i][col - (row - i)]) return false;
            if (col + (row - i) < 8 && board[i][col + (row - i)]) return false;
        }
        return true;
    }

    private static void printBoard(boolean[][] board) {
        for (boolean[] rows : board) {
            for (boolean cell : rows) {
                System.out.print(cell ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}