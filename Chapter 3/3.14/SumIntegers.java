import java.util.Scanner;

public class SumIntegers {
    public static void main(String[] args) {
        // Sum of first 100 integers
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        System.out.println("Sum of first 100 integers: " + total);

        // Sum of arbitrary integers
        Scanner input = new Scanner(System.in);
        int sum = 0, number;

        System.out.println("Enter positive integers (-1 to stop):");
        while ((number = input.nextInt()) != -1) {
            sum += number;
        }
        System.out.println("Sum of arbitrary integers: " + sum);
    }
}
