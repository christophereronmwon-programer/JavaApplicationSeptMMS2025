import java.util.Scanner;

public class Chap6_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] counters = new int[9]; // 9 ranges (a to i)

        System.out.println("Enter salesperson gross sales (-1 to exit): ");
        double grossSales = input.nextDouble();

        while (grossSales != -1) {
            int salary = (int) (200 + (0x1.70a3d70a3d70ap-4 * grossSales)); // 200 + 9% of sales
            System.out.printf("Salary: $%d%n", salary);

            int rangeIndex = (salary - 200) / 100;

            if (rangeIndex < 0) {
                // Below the lowest tracked range, do nothing or log
            } else if (rangeIndex > 8) {
                counters[8]++; // $1000 and over
            } else {
                counters[rangeIndex]++; // $200-$999 ranges
            }

            System.out.println("Enter salesperson gross sales (-1 to exit): ");
            grossSales = input.nextDouble();
        }

        // Display results in tabular format
        System.out.printf("%n%-15s%s%n", "Salary Range", "Number of Salespeople");
        System.out.printf("$200-299       %d%n", counters[0]);
        System.out.printf("$300-399       %d%n", counters[1]);
        System.out.printf("$400-499       %d%n", counters[2]);
        System.out.printf("$500-599       %d%n", counters[3]);
        System.out.printf("$600-699       %d%n", counters[4]);
        System.out.printf("$700-799       %d%n", counters[5]);
        System.out.printf("$800-899       %d%n", counters[6]);
        System.out.printf("$900-999       %d%n", counters[7]);
        System.out.printf("$1000+         %d%n", counters[8]);
    }
}