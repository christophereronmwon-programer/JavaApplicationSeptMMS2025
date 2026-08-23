// 6.12 Duplicate Elimination
import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] unique = new int[5];
        int count = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number between 10 and 100: ");
            int num = input.nextInt();
            boolean duplicate = false;

            for (int j = 0; j < count; j++) {
                if (unique[j] == num) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                unique[count++] = num;
                System.out.println("Unique numbers so far:");
                for (int k = 0; k < count; k++) System.out.print(unique[k] + " ");
                System.out.println();
            }
        }
    }
}