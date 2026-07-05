import java.util.Scanner;

public class Chap5_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter integer base: ");
        int base = input.nextInt();
        
        System.out.print("Enter positive integer exponent: ");
        int exponent = input.nextInt();
        
        if (exponent <= 0) {
            System.out.println("Exponent must be a positive, nonzero integer.");
        } else {
            int result = integerPower(base, exponent);
            System.out.printf("%d raised to the power of %d is: %d%n", base, exponent, result);
        }
        input.close();
    }
    
    public static int integerPower(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}