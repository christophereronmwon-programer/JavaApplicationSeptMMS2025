import java.util.Scanner;

public class Chap6_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 5 products (rows 0-4), 4 salespeople (cols 0-3)
        double[][] sales = new double[5][4];

        System.out.println("Enter sales data (-1 for salesperson to end input process):");
        while (true) {
            System.out.print("Enter Salesperson number (1-4): ");
            int person = input.nextInt();
            if (person == -1) break;

            System.out.print("Enter Product number (1-5): ");
            int product = input.nextInt();

            System.out.print("Enter Total dollar value: ");
            double value = input.nextDouble();

            if (person >= 1 && person <= 4 && product >= 1 && product <= 5) {
                sales[product - 1][person - 1] += value;
            } else {
                System.out.println("Invalid salesperson or product range.");
            }
        }

        // Print header
        System.out.printf("%n%-10s", "Product");
        for (int i = 1; i <= 4; i++) {
            System.out.printf("%14s%d", "Salesperson ", i);
        }
        System.out.printf("%15s%n", "Total");

        double[] colTotals = new double[4];

        // Print rows and calculate row cross-totals
        for (int row = 0; row < sales.length; row++) {
            System.out.printf("%-10d", row + 1);
            double rowTotal = 0;
            for (int col = 0; col < sales[row].length; col++) {
                System.out.printf("%15.2f", sales[row][col]);
                rowTotal += sales[row][col];
                colTotals[col] += sales[row][col];
            }
            System.out.printf("%15.2f%n", rowTotal);
        }

        // Print column cross-totals at the bottom
        System.out.printf("%-10s", "Total");
        double grandTotal = 0;
        for (double colTotal : colTotals) {
            System.out.printf("%15.2f", colTotal);
            grandTotal += colTotal;
        }
        System.out.printf("%15.2f%n", grandTotal);
    }
}