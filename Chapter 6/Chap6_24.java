public class Chap6_24 {
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];
        int queensPlaced = 0;

        while (queensPlaced < 8) {
            int minElimination = 65;
            int bestRow = -1, bestCol = -1;

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (isSafe(row, col, board)) {
                        int eliminationVal = getEliminationValue(row, col, board);
                        if (eliminationVal < minElimination) {
                            minElimination = eliminationVal;
                            bestRow = row;
                            bestCol = col;
                        }
                    }
                }
            }

            if (bestRow == -1) break; // Blocked out

            board[bestRow][bestCol] = true;
            queensPlaced++;
        }

        System.out.printf("Queens successfully placed: %d%n", queensPlaced);
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int row, int col, boolean[][] board) {
        for (int i = 0; i < 8; i++) {
            if (board[row][i] || board[i][col]) return false;
            if (row - i >= 0 && col - i >= 0 && board[row - i][col - i]) return false;
            if (row - i >= 0 && col + i < 8 && board[row - i][col + i]) return false;
            if (row + i < 8 && col - i >= 0 && board[row + i][col - i]) return false;
            if (row + i < 8 && col + i < 8 && board[row + i][col + i]) return false;
        }
        return true;
    }

    private static int getEliminationValue(int row, int col, boolean[][] board) {
        int count = 0;
        // Approximation of spaces hit by adding this target placement configuration
        for (int i = 0; i < 8; i++) {
            if (!board[row][i]) count++;
            if (!board[i][col]) count++;
        }
        return count;
    }
}