import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, num3;
        int sum;
        double average;

        // Accepting three numbers from the user
        System.out.print("Enter first number: ");
        num1 = input.nextInt();

        System.out.print("Enter second number: ");
        num2 = input.nextInt();

        System.out.print("Enter third number: ");
        num3 = input.nextInt();

        // Calculating sum
        sum = num1 + num2 + num3;

        // Calculating average
        average = sum / 3.0;

        // Displaying result
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        input.close();
    }
}