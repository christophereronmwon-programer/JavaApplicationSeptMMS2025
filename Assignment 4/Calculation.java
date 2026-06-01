import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        
        for (int i = 1; i <= 10; i++) {

            System.out.print("Enter number " + i + ": ");
            number = input.nextInt();

            
            if (i == 1 || i == 5 || i == 10) {
                sum1 = sum1 + number;
            }

            if (i == 3 || i == 8 || i == 2) {
                sum2 = sum2 + number;
            }

            
            if (i == 4 || i == 7 || i == 6 || i == 9) {
                sum3 = sum3 + number;
            }
        }

        
        int product = sum1 * sum2;

        int result = sum3 - product;

        System.out.println("Final Result = " + result);

       
        if (result >= 100) {
            System.out.println("Hurray I did it");
        } else {
            System.out.println("I still need to learn more in Java");
        }

       
    }
}