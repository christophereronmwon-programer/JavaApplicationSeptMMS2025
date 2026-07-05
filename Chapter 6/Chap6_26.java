public class Chap6_26 {
    private static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        int startRow = 0, startCol = 0;
        int currentRow = startRow, currentColumn = startCol;
        int moveCount = 1;
        board[currentRow][currentColumn] = moveCount;

        // Perform basic sequential simulation jumps
        while (moveCount < 64) {
            int nextMoveIndex = getNextHeuristicMove(currentRow, currentColumn, board);
            if (nextMoveIndex == -1) break;

            currentRow += vertical[nextMoveIndex];
            currentColumn += horizontal[nextMoveIndex];
            moveCount++;
            board[currentRow][currentColumn] = moveCount;
        }

        if (moveCount == 64) {
            boolean closedTour = false;
            for (int i = 0; i < 8; i++) {
                if (currentRow + vertical[i] == startRow && currentColumn + horizontal[i] == startCol) {
                    closedTour = true;
                    break;
                }
            }
            System.out.println(closedTour ? "Success! Found a CLOSED full tour!" : "Full tour found, but it is OPEN.");
        } else {
            System.out.println("Tour ended prematurely.");
        }
    }

    private static int getNextHeuristicMove(int r, int c, int[][] board) {
        for (int i = 0; i < 8; i++) {
            int nr = r + vertical[i];
            int nc = c + horizontal[i];
            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && board[nr][nc] == 0) return i;
        }
        return -1;
    }
}