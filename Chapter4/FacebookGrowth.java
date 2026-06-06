public class FacebookGrowth {

    public static void main(String[] args) {

        double users = 1.0; // in billions
        double rate = 0.04;

        System.out.printf("%-10s %-20s%n", "Month", "Users (billions)");

        for (int month = 1; month <= 25; month++) {

            users = 1.0 * Math.pow(1.0 + rate, month);

            System.out.printf("%-10d %-20.4f%n", month, users);
        }

        System.out.println("\nAnalysis:");
        System.out.println("1.5 billion reached at about month 10");
        System.out.println("2.0 billion reached at about month 18");
    }
}