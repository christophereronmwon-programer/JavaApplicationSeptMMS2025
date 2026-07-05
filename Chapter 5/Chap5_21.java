import java.util.Scanner;

public class Chap5_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer between 1 and 99999: ");
        int number = input.nextInt();
        
        if (number >= 1 && number <= 99999) {
            displayDigits(number);
        } else {
            System.out.println("Invalid number range entered.");
        }
        input.close();
    }
    
    public static int getQuotient(int a, int b) {
        return a / b;
    }
    
    public static int getRemainder(int a, int b) {
        return a % b;
    }
    
    public static void displayDigits(int number) {
        int divisor = 10000;
        boolean startedPrinting = false;
        
        while (divisor > 0) {
            int digit = getQuotient(number, divisor);
            
            // Avoid printing leading spaces/zeros for smaller integers
            if (digit > 0 || startedPrinting || divisor == 1) {
                System.out.print(digit + "  ");
                startedPrinting = true;
            }
            
            number = getRemainder(number, divisor);
            divisor = getQuotient(divisor, 10);
        }
        System.out.println();
    }
}