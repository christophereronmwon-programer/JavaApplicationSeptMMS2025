public class VariableLengthArgumentOdd {
    public static void main(String[] args) {
        System.out.printf("The count of odd numbers is %d%n", countOdd(5, 6, 8, 9, 3, 2, 1));
        System.out.printf("The count of odd numbers is %d%n", countOdd(5, 6, 8, 9, 3, 2));
        System.out.printf("The count of odd numbers is %d%n", countOdd(5, 6, 8, 9, 3));
        System.out.printf("The count of odd numbers is %d%n", countOdd(5, 6, 8, 9));
        System.out.printf("The count of odd numbers is %d%n", countOdd(5, 6, 8));
        System.out.printf("The count of odd numbers is %d%n", countOdd(5, 6));
        System.out.printf("The count of odd numbers is %d%n", countOdd(8));
        System.out.printf("The count of odd numbers is %d%n", countOdd());
    }

    public static int countOdd(int... numbers) {
        int oddCount = 0;

        for (int number : numbers) {
            if (number % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount;
    }
}