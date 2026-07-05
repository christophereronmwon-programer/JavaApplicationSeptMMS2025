import java.util.Scanner;

public class Chap5_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter side 1: ");
        double side1 = input.nextDouble();
        
        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();
        
        double result = hypotenuse(side1, side2);
        System.out.printf("The length of the hypotenuse is: %.2f%n", result);
        
        input.close();
    }
    
    public static double hypotenuse(double side1, double side2) {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }
}