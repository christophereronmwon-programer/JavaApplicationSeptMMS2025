
package SavingsAccount;


public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance) {
        savingsBalance = balance;
    }

    public void calculateMonthlyInterest() {

        double interest =
                savingsBalance * annualInterestRate / 12;

        savingsBalance += interest;
    }

    public static void modifyInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public double getBalance() {
        return savingsBalance;
    }
}