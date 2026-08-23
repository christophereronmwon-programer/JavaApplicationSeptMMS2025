
package TicTacToe;


import java.util.Scanner;

public class TicTacToe {

    private Cell[][] board = new Cell[3][3];
    private Scanner input = new Scanner(System.in);

    public TicTacToe() {

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = Cell.EMPTY;
    }

    public void displayBoard() {

        System.out.println();

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == Cell.EMPTY)
                    System.out.print("- ");
                else
                    System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public boolean makeMove(int row, int col, Cell player) {

        if (row < 0 || row > 2 || col < 0 || col > 2)
            return false;

        if (board[row][col] != Cell.EMPTY)
            return false;

        board[row][col] = player;

        return true;
    }

    public boolean checkWinner(Cell player) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player)
                return true;

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player)
                return true;
        }

        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player)
            return true;

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player)
            return true;

        return false;
    }

    public boolean isDraw() {

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (board[row][col] == Cell.EMPTY)
                    return false;

        return true;
    }

    public void playGame() {

        Cell currentPlayer = Cell.X;

        while (true) {

            displayBoard();

            System.out.println("Player " + currentPlayer);

            System.out.print("Enter row (0-2): ");
            int row = input.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = input.nextInt();

            if (!makeMove(row, col, currentPlayer)) {

                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (checkWinner(currentPlayer)) {

                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isDraw()) {

                displayBoard();
                System.out.println("Game Draw!");
                break;
            }

            if (currentPlayer == Cell.X)
                currentPlayer = Cell.O;
            else
                currentPlayer = Cell.X;
        }
    }
}
