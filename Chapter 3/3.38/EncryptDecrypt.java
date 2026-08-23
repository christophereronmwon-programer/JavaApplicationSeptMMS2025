import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 4-digit number: ");
        int number = input.nextInt();

        int[] digits = new int[4];
        for (int i = 3; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Encrypt
        for (int i = 0; i < 4; i++) {
            digits[i] = (digits[i] + 7) % 10;
        }

        // Swap
        int temp = digits[0]; digits[0] = digits[2]; digits[2] = temp;
        temp = digits[1]; digits[1] = digits[3]; digits[3] = temp;

        System.out.print("Encrypted number: ");
        for (int d : digits) System.out.print(d);
        System.out.println();
    }
}
