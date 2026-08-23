
package bankAccount;



public class Balance extends Account{
    public void BalanceOfAccount(String accountHolder, String accountNumber, double initialBalance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
}
