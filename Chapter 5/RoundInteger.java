import java.util.Scanner;

public class RoundInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter numbers to round. Enter -1 to exit.");
        
        while (true) {
            System.out.print("Enter a double value: ");
            double number = input.nextDouble();
            
            if (number == -1) {
                break;
            }
            
            double roundedNumber = Math.floor(number + 0.5);
            
            System.out.printf("Original: %f | Rounded to Nearest Integer: %.0f%n%n", 
                number, roundedNumber);
        }
        input.close();
    }
}