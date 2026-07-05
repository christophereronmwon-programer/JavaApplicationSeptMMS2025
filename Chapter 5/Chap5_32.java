import java.util.Scanner;

public class Chap5_32 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter x1 and y1 coordinates (separated by space): ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        
        System.out.print("Enter x2 and y2 coordinates (separated by space): ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        
        double dist = distance(x1, y1, x2, y2);
        System.out.printf("The geometric distance between points is: %f%n", dist);
        
        input.close();
    }
    
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}