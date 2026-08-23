
package Bank;

public class Main {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("12345", "CJ", 1000.0, 5.0);

        account.displayBalance();
        account.deposit(500);
        account.withdraw(200);
        account.calculateInterest();
        account.displayBalance();
    }
}

