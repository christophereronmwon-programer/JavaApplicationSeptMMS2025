import java.security.SecureRandom;
import java.util.Scanner;

public class Chap5_33 {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private enum Status { CONTINUE, WON, LOST };

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bankBalance = 1000;
        
        System.out.printf("Welcome to the table! Initial bank balance: $%d%n", bankBalance);
        
        while (bankBalance > 0) {
            int wager;
            do {
                System.out.printf("Enter your wager (Current Balance: $%d): ", bankBalance);
                wager = input.nextInt();
                if (wager > bankBalance || wager <= 0) {
                    System.out.println("Invalid wager. You cannot bet more than your available funds.");
                }
            } while (wager > bankBalance || wager <= 0);
            
            displayChatter();
            
            boolean playerWon = runCrapsGame();
            
            if (playerWon) {
                bankBalance += wager;
                System.out.printf("You won! New balance: $%d%n%n", bankBalance);
            } else {
                bankBalance -= wager;
                System.out.printf("You lost! New balance: $%d%n%n", bankBalance);
                if (bankBalance == 0) {
                    System.out.println("Sorry. You busted!");
                }
            }
            
            if (bankBalance > 0) {
                System.out.print("Keep playing? (y/n): ");
                if (!input.next().equalsIgnoreCase("y")) break;
            }
        }
        input.close();
    }

    public static boolean runCrapsGame() {
        int myPoint = 0; 
        Status gameStatus; 
        int sumOfDice = rollDice(); 

        switch (sumOfDice) {
            case SEVEN, YO_LEVEN -> gameStatus = Status.WON;
            case SNAKE_EYES, TREY, BOX_CARS -> gameStatus = Status.LOST;
            default -> {
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.printf("Point is %d%n", myPoint);
            }
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice(); 
            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else if (sumOfDice == SEVEN) {
                gameStatus = Status.LOST;
            }
        }

        return gameStatus == Status.WON;
    }

    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6); 
        int die2 = 1 + randomNumbers.nextInt(6); 
        int sum = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
        return sum;
    }

    public static void displayChatter() {
        int selection = 1 + randomNumbers.nextInt(3);
        String message = switch(selection) {
            case 1 -> "Oh, you're going for broke, huh?";
            case 2 -> "Aw c'mon, take a chance!";
            default -> "You're up big. Now's the time to cash in your chips!";
        };
        System.out.println("\n[Dealer]: " + message);
    }
}