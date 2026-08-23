import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter four digit number: ");
        int number = input.nextInt();

        int a = (number / 1000 + 7) % 10;
        int b = (number / 100 % 10 + 7) % 10;
        int c = (number / 10 % 10 + 7) % 10;
        int d = (number % 10 + 7) % 10;

        System.out.println("" + c + d + a + b);
    }
}
