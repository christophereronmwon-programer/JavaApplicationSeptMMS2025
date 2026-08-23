import java.util.Scanner;

public class NumberCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];

        // Accept 10 numbers
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }

        // Step 1: Sum of 1st, 5th, 10th
        int sum1 = numbers[0] + numbers[4] + numbers[9];

        // Step 2: Sum of 3rd, 8th, 2nd
        int sum2 = numbers[2] + numbers[7] + numbers[1];

        // Step 3: Multiply sum1 and sum2
        int product = sum1 * sum2;

        // Step 4: Sum of 4th, 7th, 6th, 9th
        int sum3 = numbers[3] + numbers[6] + numbers[5] + numbers[8];

        // Step 5: Subtract product from sum3
        int result = sum3 - product;

        // Step 6: Check condition
        if (result >= 100) {
            System.out.println("Hurray, I did it!");
        } else {
            System.out.println("I still need to learn more in Java");
        }

        sc.close();
    }
}
