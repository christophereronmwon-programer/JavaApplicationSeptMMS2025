import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num;

        // Accept a number
        System.out.print("Enter a number: ");
        num = input.nextInt();

        // Check even or odd without using if
        String result = (num % 2 == 0) ? "Even" : "Odd";

        // Display result
        System.out.println("The number " + num + " is " + result);

        input.close();
    }
}