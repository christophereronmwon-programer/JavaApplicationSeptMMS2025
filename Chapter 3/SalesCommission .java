import java.util.Scanner;

public class SalesCommission {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double totalSales = 0;

        while (true) {

            System.out.print("Enter item value (0 to stop): ");
            double item = input.nextDouble();

            if (item == 0)
                break;

            totalSales += item;
        }

        double salary = 200 + (0.09 * totalSales);

        System.out.println("Total earnings: " + salary);
    }
}
