import java.util.Scanner;

public class Chap5_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter integer values to test if they are even or odd.");
        System.out.println("Enter -999 to exit.");
        
        while (true) {
            System.out.print("Enter integer: ");
            int value = input.nextInt();
            
            if (value == -999) {
                break;
            }
            
            if (isEven(value)) {
                System.out.printf("%d is Even.%n%n", value);
            } else {
                System.out.printf("%d is Odd.%n%n", value);
            }
        }
        input.close();
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}