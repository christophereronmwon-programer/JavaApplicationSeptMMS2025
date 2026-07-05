import java.util.Scanner;

public class Chap5_27 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int first = input.nextInt();
        
        System.out.print("Enter second number: ");
        int second = input.nextInt();
        
        int commonDivisor = gcd(first, second);
        System.out.printf("The GCD of %d and %d is: %d%n", first, second, commonDivisor);
        
        input.close();
    }
    
    // Implementation of Euclid's Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}