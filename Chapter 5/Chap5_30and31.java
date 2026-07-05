import java.security.SecureRandom;
import java.util.Scanner;

public class Chap5_30and31 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Scanner input = new Scanner(System.in);
        String playAgain;

        do {
            int targetNumber = 1 + random.nextInt(1000);
            int guessCount = 0;
            int currentGuess = 0;
            
            System.out.println("\nGuess a number between 1 and 1000.");
            
            while (currentGuess != targetNumber) {
                System.out.print("Enter guess: ");
                currentGuess = input.nextInt();
                guessCount++;
                
                if (currentGuess > targetNumber) {
                    System.out.println("Too high. Try again.");
                } else if (currentGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                }
            }
            
            System.out.println("Congratulations. You guessed the number!");
            System.out.printf("Total attempts: %d%n", guessCount);
            
            // 5.31 feedback rules
            if (guessCount < 10) {
                System.out.println("Either you know the secret or you got lucky!");
            } else if (guessCount == 10) {
                System.out.println("Aha! You know the secret!");
            } else {
                System.out.println("You should be able to do better! (Binary search requires a maximum of 10 cuts)");
            }
            
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = input.next();
            
        } while (playAgain.equalsIgnoreCase("y"));
        
        input.close();
    }
}