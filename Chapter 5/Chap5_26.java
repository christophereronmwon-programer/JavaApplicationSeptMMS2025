import java.util.Scanner;

public class Chap5_26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer value to reverse: ");
        int value = input.nextInt();
        
        int reversedValue = reverseDigits(value);
        System.out.printf("Reversed sequence: %d%n", reversedValue);
        
        input.close();
    }
    
    public static int reverseDigits(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = (reversed * 10) + digit;
            number /= 10;
        }
        return reversed;
    }
}