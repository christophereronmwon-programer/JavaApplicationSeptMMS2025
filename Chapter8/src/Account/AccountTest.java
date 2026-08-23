
package Account;

import java.math.BigDecimal;

public class AccountTest {

    public static void main(String[] args) {

        Account account =
                new Account("Tammy",
                        new BigDecimal("5000.00"));

        System.out.println("Account Name: "
                + account.getName());

        System.out.println("Balance: $"
                + account.getBalance());

        account.deposit(new BigDecimal("1500.50"));

        System.out.println("After Deposit: $"
                + account.getBalance());

        account.withdraw(new BigDecimal("1000.25"));

        System.out.println("After Withdrawal: $"
                + account.getBalance());

    }

}
