public class SumHundredNumbers {
    public static void main(String[] args) {
        int x = 1, total = 0;

        while (x <= 100) {
            total += x;
            ++x;
        }

        System.out.println("Total sum from 1 to 100 is: " + total);
    }
}
