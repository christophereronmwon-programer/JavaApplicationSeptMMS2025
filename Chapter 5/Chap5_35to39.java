import java.security.SecureRandom;
import java.util.Scanner;

public class Chap5_35to39 {
    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Computer Assisted Instruction System ===");
        
        while (true) {
            System.out.print("\nEnter difficulty level (1=single digit numbers, 2=two digit, etc): ");
            int difficulty = input.nextInt();
            
            System.out.println("Choose arithmetic type:\n1 = Addition Only\n2 = Subtraction Only\n3 = Multiplication Only\n4 = Division Only\n5 = Random Mixture");
            System.out.print("Selection: ");
            int problemType = input.nextInt();
            
            runTestSession(difficulty, problemType);
            
            System.out.print("\nReset platform for next student? (y/n): ");
            if (!input.next().equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public static void runTestSession(int level, int type) {
        int correctResponses = 0;
        int totalQuestions = 10;
        
        for (int q = 1; q <= totalQuestions; q++) {
            int n1 = generateOperand(level);
            int n2 = generateOperand(level);
            
            // Resolve variation patterns
            int operationalType = (type == 5) ? 1 + random.nextInt(4) : type;
            
            // Adjust to cleanly fit dynamic division boundaries
            if (operationalType == 4) {
                if (n2 == 0) n2 = 1;
                n1 = n1 * n2; 
            }
            
            int expectedValue = calculateExpected(n1, n2, operationalType);
            char signSymbol = fetchSymbol(operationalType);
            
            System.out.printf("%nQuestion %d: How much is %d %c %d? ", q, n1, signSymbol, n2);
            int studentGuess = input.nextInt();
            
            // 5.35 variation modification: infinite retry or clean assessment tracks
            if (studentGuess == expectedValue) {
                System.out.println(fetchFeedback(true));
                correctResponses++;
            } else {
                System.out.println(fetchFeedback(false));
                System.out.printf("The accurate calculation was: %d%n", expectedValue);
            }
        }
        
        double rawPerformance = ((double) correctResponses / totalQuestions) * 100;
        System.out.printf("%nSession metrics collected. Final score: %.1f%%%n", rawPerformance);
        
        if (rawPerformance < 75.0) {
            System.out.println("Please ask your teacher for extra help.");
        } else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    private static int generateOperand(int level) {
        int baseLowerBound = (level == 1) ? 0 : (int) Math.pow(10, level - 1);
        int capLimitRange = (int) Math.pow(10, level) - baseLowerBound;
        return baseLowerBound + random.nextInt(capLimitRange);
    }

    private static int calculateExpected(int num1, int num2, int operationalIndex) {
        return switch (operationalIndex) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> num1 / num2;
            default -> 0;
        };
    }

    private static char fetchSymbol(int mode) {
        return switch (mode) {
            case 1 -> '+';
            case 2 -> '-';
            case 3 -> '*';
            default -> '/';
        };
    }

    private static String fetchFeedback(boolean isCorrect) {
        int index = 1 + random.nextInt(4);
        if (isCorrect) {
            return switch (index) {
                case 1 -> "Very good!";
                case 2 -> "Excellent!";
                case 3 -> "Nice work!";
                default -> "Keep up the good work!";
            };
        } else {
            return switch (index) {
                case 1 -> "No. Please try again.";
                case 2 -> "Wrong. Try once more.";
                case 3 -> "Don't give up!";
                default -> "Keep trying.";
            };
        }
    }
}