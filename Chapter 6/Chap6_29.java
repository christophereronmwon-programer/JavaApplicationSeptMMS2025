import java.util.Scanner;

public class Chap6_29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value for n to compute Fibonacci number: ");
        int n = input.nextInt();
        
        System.out.printf("Fibonacci(%d) using int: %d%n", n, fibonacciInt(n));
        System.out.printf("Fibonacci(%d) using double: %.0f%n", n, fibonacciDouble(n));

        // Note for part b: Max exact standard value printable with int index is n=46
    }

    public static int fibonacciInt(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static double fibonacciDouble(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        double a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            double temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}