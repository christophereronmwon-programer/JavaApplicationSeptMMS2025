import java.util.Scanner;

public class Chap5_23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter three floating-point values separated by spaces: ");
        double n1 = input.nextDouble();
        double n2 = input.nextDouble();
        double n3 = input.nextDouble();
        
        double minimum = minimum3(n1, n2, n3);
        System.out.printf("The minimum value is: %f%n", minimum);
        
        input.close();
    }
    
    public static double minimum3(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }
}