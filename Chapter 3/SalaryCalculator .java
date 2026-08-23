import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {

            System.out.print("Enter hours worked: ");
            double hours = input.nextDouble();

            System.out.print("Enter hourly rate: ");
            double rate = input.nextDouble();

            double gross;

            if (hours <= 40)
                gross = hours * rate;
            else
                gross = (40 * rate) + ((hours - 40) * rate * 1.5);

            System.out.println("Gross pay: " + gross);
        }
    }
}
