import java.util.Scanner;

public class Chap5_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a double value to round: ");
        double value = input.nextDouble();
        
        System.out.printf("Original value: %f%n", value);
        System.out.printf("Rounded to Integer:    %.0f%n", roundToInteger(value));
        System.out.printf("Rounded to Tenths:     %.1f%n", roundToTenths(value));
        System.out.printf("Rounded to Hundredths: %.2f%n", roundToHundredths(value));
        System.out.printf("Rounded to Thousandths:%.3f%n", roundToThousandths(value));
        
        input.close();
    }
    
    public static double roundToInteger(double number) {
        return Math.floor(number + 0.5);
    }
    
    public static double roundToTenths(double number) {
        return Math.floor(number * 10 + 0.5) / 10;
    }
    
    public static double roundToHundredths(double number) {
        return Math.floor(number * 100 + 0.5) / 100;
    }
    
    public static double roundToThousandths(double number) {
        return Math.floor(number * 1000 + 0.5) / 1000;
    }
}