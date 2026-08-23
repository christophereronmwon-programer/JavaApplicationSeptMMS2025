
package SavingsAccount;


public class SavingsTest {

    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(0.04);

        System.out.println("Interest Rate = 4%");

        for (int i = 1; i <= 12; i++) {

            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            System.out.printf("Month %d%n", i);
            System.out.printf("Saver1 = %.2f%n", saver1.getBalance());
            System.out.printf("Saver2 = %.2f%n%n", saver2.getBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Interest Rate = 5%");

        System.out.printf("Saver1 = %.2f%n", saver1.getBalance());
        System.out.printf("Saver2 = %.2f%n", saver2.getBalance());
    }
}