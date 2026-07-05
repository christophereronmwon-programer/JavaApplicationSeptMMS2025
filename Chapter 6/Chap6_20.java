import java.util.Scanner;

public class Chap6_20 {
    private static final int[][] floor = new int[20][20];
    private static int currentRow = 0;
    private static int currentColumn = 0;
    private static boolean penDown = false;
    // Directions: 0 = East, 1 = South, 2 = West, 3 = North
    private static int direction = 0; 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter commands (9 to execute/end):");

        while (true) {
            String commandStr = input.next();
            if (commandStr.equals("9")) break;

            if (commandStr.startsWith("5,")) {
                int steps = Integer.parseInt(commandStr.substring(2));
                moveTurtle(steps);
            } else {
                int command = Integer.parseInt(commandStr);
                processCommand(command);
            }
        }
    }

    private static void processCommand(int command) {
        switch (command) {
            case 1: penDown = false; break;
            case 2: penDown = true; break;
            case 3: direction = (direction + 1) % 4; break; // Turn Right
            case 4: direction = (direction + 3) % 4; break; // Turn Left
            case 6: displayFloor(); break;
        }
    }

    private static void moveTurtle(int steps) {
        for (int i = 0; i < steps; i++) {
            if (penDown) {
                floor[currentRow][currentColumn] = 1;
            }

            switch (direction) {
                case 0: if (currentColumn < 19) currentColumn++; break; // East
                case 1: if (currentRow < 19) currentRow++; break;       // South
                case 2: if (currentColumn > 0) currentColumn--; break;  // West
                case 3: if (currentRow > 0) currentRow--; break;        // North
            }
        }
    }

    private static void displayFloor() {
        for (int[] row : floor) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "* " : ". ");
            }
            System.out.println();
        }
    }
}