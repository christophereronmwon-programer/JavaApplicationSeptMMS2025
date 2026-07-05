public class Chap6_21 {
    private static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    
    public static void main(String[] args) {
        // Run full heuristic tour from standard top-left corner
        int[][] board = new int[8][8];
        int[][] accessibility = {
            {2, 3, 4, 4, 4, 4, 3, 2},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {2, 3, 4, 4, 4, 4, 3, 2}
        };

        int currentRow = 0;
        int currentColumn = 0;
        int moveCount = 1;
        board[currentRow][currentColumn] = moveCount;

        while (moveCount < 64) {
            int minAccess = 9;
            int bestMove = -1;

            for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
                int nextRow = currentRow + vertical[moveNumber];
                int nextCol = currentColumn + horizontal[moveNumber];

                if (isValidMove(nextRow, nextCol, board)) {
                    if (accessibility[nextRow][nextCol] < minAccess) {
                        minAccess = accessibility[nextRow][nextCol];
                        bestMove = moveNumber;
                    }
                }
            }

            if (bestMove == -1) break; // Trapped

            // Update accessibility metrics dynamically
            reduceAccessibility(currentRow, currentColumn, accessibility);

            currentRow += vertical[bestMove];
            currentColumn += horizontal[bestMove];
            moveCount++;
            board[currentRow][currentColumn] = moveCount;
        }

        System.out.printf("Total moves made: %d%n%n", moveCount);
        printBoard(board);
    }

    private static boolean isValidMove(int row, int col, int[][] board) {
        return (row >= 0 && row < 8 && col >= 0 && col < 8 && board[row][col] == 0);
    }

    private static void reduceAccessibility(int row, int col, int[][] access) {
        for (int i = 0; i < 8; i++) {
            int targetRow = row + vertical[i];
            int targetCol = col + horizontal[i];
            if (targetRow >= 0 && targetRow < 8 && targetCol >= 0 && targetCol < 8) {
                access[targetRow][targetCol]--;
            }
        }
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
    }
}