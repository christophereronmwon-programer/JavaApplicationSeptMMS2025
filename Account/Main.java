
package Account;

public class Main {
    public static void main(String[] args) {
        // Create SavingsAccount
        SavingsAccount savings = new SavingsAccount("S123", "CJ", 1000.0, 5.0);
        savings.displayBalance();
        savings.deposit(500);
        savings.withdraw(200);
        savings.calculateInterest();
        savings.displayBalance();

        System.out.println("-----------------------------");

        // Create CurrentAccount
        CurrentAccount current = new CurrentAccount("C456", "CJ", 2000.0, 1000.0);
        current.displayBalance();
        current.deposit(300);
        current.withdraw(2500);
        current.calculateInterest();
        current.displayBalance();
    }
}

