import java.util.Scanner;

public class Chap5_22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Select option:\n1. Fahrenheit to Celsius\n2. Celsius to Fahrenheit");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        
        if (choice == 1) {
            System.out.print("Enter Fahrenheit temperature: ");
            double fahrenheit = input.nextDouble();
            System.out.printf("Celsius equivalent: %.2f °C%n", celsius(fahrenheit));
        } else if (choice == 2) {
            System.out.print("Enter Celsius temperature: ");
            double celsius = input.nextDouble();
            System.out.printf("Fahrenheit equivalent: %.2f °F%n", fahrenheit(celsius));
        } else {
            System.out.println("Invalid selection.");
        }
        input.close();
    }
    
    public static double celsius(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }
    
    public static double fahrenheit(double celsius) {
        return 9.0 / 5.0 * celsius + 32;
    }
}