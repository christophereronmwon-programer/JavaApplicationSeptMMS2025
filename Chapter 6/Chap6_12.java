import java.util.Scanner;

public class Chap6_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] uniqueValues = new int[5];
        int count = 0; // tracks number of valid unique items entered

        while (count < 5) {
            System.out.print("Enter an integer between 10 and 100: ");
            int number = input.nextInt();

            if (number >= 10 && number <= 100) {
                boolean isDuplicate = false;

                // Check if number is already in the array
                for (int i = 0; i < count; i++) {
                    if (uniqueValues[i] == number) {
                        isDuplicate = true;
                        break;
                    }
                }

                // If unique, store it and display it
                if (!isDuplicate) {
                    uniqueValues[count] = number;
                    System.out.printf("Unique value read: %d%n", number);
                    count++;
                } else {
                    System.out.printf("%d has already been entered.%n", number);
                }

                // Display complete set of unique values input so far
                System.out.print("Unique values so far: ");
                for (int i = 0; i < count; i++) {
                    System.out.print(uniqueValues[i] + " ");
                }
                System.out.println("\n");
            } else {
                System.out.println("Number must be between 10 and 100.");
            }
        }
    }
}