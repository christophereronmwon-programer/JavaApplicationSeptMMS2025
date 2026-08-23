// 6.17 Dice Rolling Simulation
import java.util.Random;

public class DiceRolling {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] tally = new int[13]; // sums from 2 to 12

        for (int i = 0; i < 36000000; i++) {
            int die1 = 1 + rand.nextInt(6);
            int die2 = 1 + rand.nextInt(6);
            tally[die1 + die2]++;
        }

        System.out.println("Sum\tFrequency");
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "\t" + tally[i]);
        }
    }
}