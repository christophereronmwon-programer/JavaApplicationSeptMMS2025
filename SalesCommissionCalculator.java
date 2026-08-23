import java.util.Scanner;

public class SalesCommissionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double grossSales = 0;

        while (true) {
            System.out.print("Enter item value (-1 to quit): ");
            double itemValue = input.nextDouble();
            if (itemValue == -1) break;
            grossSales += itemValue;
        }

        double earnings = 200 + 0.09 * grossSales;
        System.out.printf("Total earnings: $%.2f%n", earnings);
    }
}
