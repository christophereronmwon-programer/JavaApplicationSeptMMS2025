import java.util.Scanner;

public class FairTaxCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double housing, food, clothing, transport, education, health, vacation;
        double totalExpenses;
        double fairTaxRate = 0.23;
        double tax;

        System.out.println("=== FAIRTAX ESTIMATOR ===\n");

        System.out.print("Enter housing expenses: ");
        housing = input.nextDouble();

        System.out.print("Enter food expenses: ");
        food = input.nextDouble();

        System.out.print("Enter clothing expenses: ");
        clothing = input.nextDouble();

        System.out.print("Enter transportation expenses: ");
        transport = input.nextDouble();

        System.out.print("Enter education expenses: ");
        education = input.nextDouble();

        System.out.print("Enter health care expenses: ");
        health = input.nextDouble();

        System.out.print("Enter vacation expenses: ");
        vacation = input.nextDouble();

        totalExpenses = housing + food + clothing + transport
                        + education + health + vacation;

        tax = totalExpenses * fairTaxRate;

        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total Consumption: " + totalExpenses);
        System.out.println("Estimated FairTax (23%): " + tax);

       

        
    }
}