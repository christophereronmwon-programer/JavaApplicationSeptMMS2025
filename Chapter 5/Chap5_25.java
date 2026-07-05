public class Chap5_25 {
    public static void main(String[] args) {
        System.out.println("Primes less than 10,000:");
        int count = 0;
        
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 15 == 0) System.out.println(); // wrap lines
            }
        }
        System.out.printf("%n%nTotal primes found: %d%n", count);
        System.out.println("To ensure you've found all primes up to 10,000, you must test all numbers up to 10,000.");
    }
    
    // Method optimized to search up to the square root of n (Part c)
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}