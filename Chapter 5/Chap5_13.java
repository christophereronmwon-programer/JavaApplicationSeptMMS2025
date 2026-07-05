import java.util.Random;

public class Chap5_13 {
    public static void main(String[] args) {
        Random rand = new Random();

        // a) Set: 2, 4, 6, 8, 10
        // Scale factor: 2 (even numbers), Shift: +2, Number of elements: 5
        int nA = 2 + 2 * rand.nextInt(5);

        // b) Set: 3, 5, 7, 9, 11
        // Scale factor: 2 (odd progression), Shift: +3, Number of elements: 5
        int nB = 3 + 2 * rand.nextInt(5);

        // c) Set: 6, 10, 14, 18, 22
        // Difference between values: 4, Shift: +6, Number of elements: 5
        int nC = 6 + 4 * rand.nextInt(5);

        System.out.printf("a) Random from {2, 4, 6, 8, 10}:   %d%n", nA);
        System.out.printf("b) Random from {3, 5, 7, 9, 11}:   %d%n", nB);
        System.out.printf("c) Random from {6, 10, 14, 18, 22}: %d%n", nC);
    }
}