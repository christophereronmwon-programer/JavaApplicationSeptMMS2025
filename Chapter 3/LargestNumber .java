
import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int largest = Integer.MIN_VALUE;

        for (int i = 1; i <= 10; i++) {

            System.out.print("Enter number: ");
            int number = input.nextInt();

            if (number > largest)
                largest = number;
        }

        System.out.println("Largest number is: " + largest);
    }
}
