
package Account;


import java.math.BigDecimal;

public class Account {

    private String name;
    private BigDecimal balance;

    // Constructor
    public Account(String name, BigDecimal balance) {

        this.name = name;

        if (balance.compareTo(BigDecimal.ZERO) >= 0)
            this.balance = balance;
        else
            this.balance = BigDecimal.ZERO;
    }

    // Deposit money
    public void deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) > 0)
            balance = balance.add(amount);
    }

    // Withdraw money
    public void withdraw(BigDecimal amount) {

        if (amount.compareTo(balance) <= 0)
            balance = balance.subtract(amount);
        else
            System.out.println("Withdrawal amount exceeded account balance.");
    }

    // Get account balance
    public BigDecimal getBalance() {
        return balance;
    }

    // Set account name
    public void setName(String name) {
        this.name = name;
    }

    // Get account name
    public String getName() {
        return name;
    }
}
