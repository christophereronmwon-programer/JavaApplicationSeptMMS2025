import java.util.Scanner;

public class TwoLargest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 1; i <= 10; i++) {

            System.out.print("Enter number: ");
            int number = input.nextInt();

            if (number > largest) {
                second = largest;
                largest = number;
            }
            else if (number > second) {
                second = number;
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second);
    }
}
