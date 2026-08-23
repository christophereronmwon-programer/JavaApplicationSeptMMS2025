import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] num = new int[10];

        // Accept 10 numbers
        System.out.println("Enter 10 numbers:");

        for (int i = 0; i < 10; i++) {
            num[i] = input.nextInt();
        }

        // Sum of 1st, 5th and 10th numbers
        int sum1 = num[0] + num[4] + num[9];

        // Sum of 3rd, 8th and 2nd numbers
        int sum2 = num[2] + num[7] + num[1];

        // Multiply the two sums
        int result1 = sum1 * sum2;

        // Sum of 4th, 7th and 9th numbers
        int sum3 = num[3] + num[6] + num[8];

        // Final calculation
        int finalResult = sum3 - result1;

        // Display result
        System.out.println("Final Result = " + finalResult);

        // Check condition
        if (finalResult >= 100) {
            System.out.println("Hurray I did it");
        } else {
            System.out.println("I still need to learn more in java");
        }
    }
}
