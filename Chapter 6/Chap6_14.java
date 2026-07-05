public class Chap6_14 {
    public static int product(int... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int total = 1;
        for (int num : numbers) {
            total *= num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.printf("Product of 2 and 3: %d%n", product(2, 3));
        System.out.printf("Product of 1, 3, 5: %d%n", product(1, 3, 5));
        System.out.printf("Product of 2, 4, 6, 8: %d%n", product(2, 4, 6, 8));
        System.out.printf("Product of no arguments: %d%n", product());
    }
}