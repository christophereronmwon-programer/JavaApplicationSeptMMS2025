// 2.14
public class DisplayNumbers {
    public static void main(String[] args) {
        
        // Using println
        System.out.println("1 2 3 4");

        // Using print
        System.out.print("1 ");
        System.out.print("2 ");
        System.out.print("3 ");
        System.out.print("4\n");

        // Using printf
        System.out.printf("%d %d %d %d%n", 1, 2, 3, 4);
    }
}
//2.15
import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2;

        System.out.print("Enter first integer: ");
        num1 = input.nextInt();

        System.out.print("Enter second integer: ");
        num2 = input.nextInt();

        System.out.println("Sum = " + (num1 + num2));
        System.out.println("Product = " + (num1 * num2));
        System.out.println("Difference = " + (num1 - num2));
        System.out.println("Quotient = " + (num1 / num2));
    }
}
//2.16
import java.util.Scanner;

public class CompareIntegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2;

        System.out.print("Enter first integer: ");
        num1 = input.nextInt();

        System.out.print("Enter second integer: ");
        num2 = input.nextInt();

        if (num1 > num2)
            System.out.println(num1 + " is larger");
        else if (num2 > num1)
            System.out.println(num2 + " is larger");
        else
            System.out.println("These numbers are equal");
    }
}
//2.17
import java.util.Scanner;

public class SmallestLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, num3;

        System.out.print("Enter first integer: ");
        num1 = input.nextInt();

        System.out.print("Enter second integer: ");
        num2 = input.nextInt();

        System.out.print("Enter third integer: ");
        num3 = input.nextInt();

        int sum = num1 + num2 + num3;
        int average = sum / 3;
        int product = num1 * num2 * num3;

        int smallest = num1;
        int largest = num1;

        if (num2 < smallest)
            smallest = num2;
        if (num3 < smallest)
            smallest = num3;

        if (num2 > largest)
            largest = num2;
        if (num3 > largest)
            largest = num3;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Product = " + product);
        System.out.println("Smallest = " + smallest);
        System.out.println("Largest = " + largest);
    }
}
//2.18
public class Shapes {
    public static void main(String[] args) {

        // Box
        System.out.println("*****");
        System.out.println("*   *");
        System.out.println("*   *");
        System.out.println("*   *");
        System.out.println("*****");

        System.out.println();

        // Oval
        System.out.println(" *** ");
        System.out.println("*   *");
        System.out.println("*   *");
        System.out.println(" *** ");

        System.out.println();

        // Arrow
        System.out.println("  *");
        System.out.println(" ***");
        System.out.println("*****");
        System.out.println("  *");
        System.out.println("  *");

        System.out.println();

        // Diamond
        System.out.println("  *");
        System.out.println(" ***");
        System.out.println("*****");
        System.out.println(" ***");
        System.out.println("  *");
    }
}