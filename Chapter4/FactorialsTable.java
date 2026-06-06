public class FactorialsTable {
    public static void main(String[] args) {

        System.out.printf("%-10s %-30s%n", "n", "n!");
        System.out.println("--------------------------------------");

        long factorial = 1;

        for (int n = 1; n <= 20; n++) {
            factorial *= n;
            System.out.printf("%-10d %-30d%n", n, factorial);
        }
    }
}