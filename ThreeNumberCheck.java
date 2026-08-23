import java.util.Scanner;

public class ThreeNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept three numbers
        System.out.println("Enter three numbers:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // Find the sum of the three numbers
        int sum = num1 + num2 + num3;

        // Check if sum is even and divisible by 10
        if (sum % 2 == 0 && sum % 10 == 0) {
            // Accept three more numbers
            System.out.println("Enter three more numbers:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // Find product
            int product = a * b * c;

            // Check if product > 200
            if (product > 200) {
                System.out.println("Hurray");
            } else {
                System.out.println("On going");
            }
        } else {
            System.out.println("I must solve this program on my own.");
        }

        sc.close();
    }
}
