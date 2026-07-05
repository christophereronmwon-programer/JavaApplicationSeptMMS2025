public class Chap5_24 {
    public static void main(String[] args) {
        System.out.println("Finding all perfect numbers between 1 and 1000:\n");
        
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                System.out.printf("%d is perfect. Factors: ", i);
                printFactors(i);
            }
        }
    }
    
    public static boolean isPerfect(int number) {
        if (number < 2) return false;
        
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
    
    public static void printFactors(int number) {
        System.out.print("1");
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                System.out.print(" + " + i);
            }
        }
        System.out.println();
    }
}