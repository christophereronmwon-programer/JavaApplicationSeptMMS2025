import java.util.Scanner;

public class ParkingGarage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double runningTotal = 0.0;
        
        System.out.println("Enter parking hours for yesterday's customers.");
        System.out.println("Enter a negative number or 0 to finish and view totals.");
        
        while (true) {
            System.out.print("Enter hours parked for current customer: ");
            double hours = input.nextDouble();
            
            if (hours <= 0) {
                break;
            }
            
            double charge = calculateCharges(hours);
            runningTotal += charge;
            
            System.out.printf("Customer Charge: $%.2f%n", charge);
            System.out.printf("Running Total of Receipts: $%.2f%n%n", runningTotal);
        }
        
        System.out.printf("Final Total Yesterday's Receipts: $%.2f%n", runningTotal);
        input.close();
    }
    
    public static double calculateCharges(double hours) {
        double baseFee = 2.00;
        if (hours <= 3.0) {
            return baseFee;
        }
        
        // Charges apply for each hour or fractional part thereof
        double extraHours = Math.ceil(hours - 3.0);
        double charge = baseFee + (extraHours * 0.50);
        
        // Cap the maximum 24-hour charge at $10.00
        return Math.min(charge, 10.00);
    }
}