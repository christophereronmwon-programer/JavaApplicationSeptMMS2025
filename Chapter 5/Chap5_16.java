import java.util.Scanner;

public class Chap5_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter pairs of integers to see if the second is a multiple of the first.");
        System.out.println("Enter 0 for the first number to stop.");
        
        while (true) {
            System.out.print("Enter first integer: ");
            int first = input.nextInt();
            
            if (first == 0) {
                break;
            }
            
            System.out.print("Enter second integer: ");
            int second = input.nextInt();
            
            boolean result = isMultiple(first, second);
            System.out.printf("Is %d a multiple of %d? %b%n%n", second, first, result);
        }
        input.close();
    }
    
    public static boolean isMultiple(int first, int second) {
        return second % first == 0;
    }
}