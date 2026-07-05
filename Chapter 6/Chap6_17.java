import java.util.Random;

public class Chap6_17 {
    public static void main(String[] args) {
        Random randomNumbers = new Random();
        int[] frequencies = new int[13]; // Indices 2 to 12 map out to standard sums

        for (int roll = 1; roll <= 36_000_000; roll++) {
            int die1 = 1 + randomNumbers.nextInt(6);
            int die2 = 1 + randomNumbers.nextInt(6);
            frequencies[die1 + die2]++;
        }

        System.out.printf("%s%15s%n", "Sum", "Frequency");
        for (int sum = 2; sum < frequencies.length; sum++) {
            System.out.printf("%2d%15d%n", sum, frequencies[sum]);
        }
    }
}