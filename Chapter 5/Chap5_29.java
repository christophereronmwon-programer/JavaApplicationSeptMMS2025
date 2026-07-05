import java.security.SecureRandom;
import java.util.Scanner;

public class Chap5_29 {
    enum Coin { HEADS, TAILS }
    
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int headsCount = 0;
        int tailsCount = 0;
        
        while (true) {
            System.out.println("Menu:\n1. Toss Coin\n2. Exit");
            System.out.print("Select choice: ");
            int choice = input.nextInt();
            
            if (choice == 2) {
                break;
            } else if (choice == 1) {
                Coin result = flip();
                if (result == Coin.HEADS) {
                    headsCount++;
                    System.out.println("Result: HEADS");
                } else {
                    tailsCount++;
                    System.out.println("Result: TAILS");
                }
                System.out.printf("Current Status -> Heads: %d, Tails: %d%n%n", headsCount, tailsCount);
            } else {
                System.out.println("Invalid menu option.");
            }
        }
        input.close();
    }
    
    public static Coin flip() {
        if (random.nextBoolean()) {
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }
}