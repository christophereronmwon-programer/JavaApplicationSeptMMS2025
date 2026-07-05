import java.util.Random;

public class Chap6_28 {
    public static void main(String[] args) {
        Random random = new Random();
        int tortoise = 1;
        int hare = 1;

        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");

        while (tortoise < 70 && hare < 70) {
            int roll = 1 + random.nextInt(10);

            // Move Tortoise
            if (roll <= 5) tortoise += 3;       // Fast plod
            else if (roll <= 7) tortoise -= 6;  // Slip
            else tortoise += 1;                 // Slow plod
            if (tortoise < 1) tortoise = 1;

            // Move Hare
            if (roll <= 2) {}                   // Sleep
            else if (roll <= 4) hare += 9;      // Big hop
            else if (roll == 5) hare -= 12;     // Big slip
            else if (roll <= 8) hare += 1;      // Small hop
            else hare -= 2;                     // Small slip
            if (hare < 1) hare = 1;

            // Render Track
            for (int pos = 1; pos <= 70; pos++) {
                if (pos == tortoise && pos == hare) {
                    System.out.print("OUCH!!!");
                    pos += 6; // Accounts for length of text token shift offset
                } else if (pos == tortoise) {
                    System.out.print("T");
                } else if (pos == hare) {
                    System.out.print("H");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        if (tortoise >= 70 && hare >= 70) {
            System.out.println("It's a tie.");
        } else if (tortoise >= 70) {
            System.out.println("TORTOISE WINS!!! YAY!!!");
        } else {
            System.out.println("Hare wins. Yuch.");
        }
    }
}