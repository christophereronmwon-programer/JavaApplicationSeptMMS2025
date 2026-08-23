public class SumTenNumbers {
    public static void main(String[] args) {
        int x = 1, total = 0;

        while (x <= 10) {
            total += x;
            ++x;
        }

        System.out.println("Total sum from 1 to 10 is: " + total);
    }
}
