import java.util.Scanner;

public class ClassWork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter third number: ");
        int num3 = input.nextInt();

        int sum = num1 + num2 + num3;

        
        if (sum % 2 == 0 && sum % 10 == 0) {

            
            System.out.println("Enter another 3 numbers:");

            int numa = input.nextInt();
            int numb = input.nextInt();
            int numc = input.nextInt();

            int product = numa * numb * numc;

            
            if (product > 200) {
                System.out.println("Hurray");
            } else {
                System.out.println("Ongoing");
            }

        } else {
            System.out.println("I must solve this program on my own.");
        }

    }
}