import java.util.Random;

public class Chap6_22 {
    private static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Random random = new Random();
        int[] tourLengths = new int[65];
        int attempts = 0;

        System.out.println("Running until a complete tour is generated...");
        long startTime = System.currentTimeMillis();

        while (true) {
            attempts++;
            int moves = runSingleRandomTour(random);
            tourLengths[moves]++;

            if (moves == 64) {
                long duration = System.currentTimeMillis() - startTime;
                System.out.printf("Success achieved after %d attempts!%n", attempts);
                System.out.printf("Time Elapsed: %.2f seconds%n%n", duration / 1000.0);
                break;
            }
        }

        System.out.printf("%-15s%-15s%n", "Tour Length", "Frequency");
        for (int i = 1; i <= 64; i++) {
            if (tourLengths[i] > 0) {
                System.out.printf("%-15d%-15d%n", i, tourLengths[i]);
            }
        }
    }

    private static int runSingleRandomTour(Random random) {
        int[][] board = new int[8][8];
        int row = random.nextInt(8);
        int col = random.nextInt(8);
        int moveCount = 1;
        board[row][col] = moveCount;

        while (true) {
            int[] validMoves = new int[8];
            int validCount = 0;

            for (int i = 0; i < 8; i++) {
                int nextRow = row + vertical[i];
                int nextCol = col + horizontal[i];
                if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8 && board[nextRow][nextCol] == 0) {
                    validMoves[validCount++] = i;
                }
            }

            if (validCount == 0) break;

            int chosenMove = validMoves[random.nextInt(validCount)];
            row += vertical[chosenMove];
            col += horizontal[chosenMove];
            moveCount++;
            board[row][col] = moveCount;
        }
        return moveCount;
    }
}