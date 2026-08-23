
package bankAccount;

public class Withdraw extends Account{
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
        else if (amount > balance){
            System.out.println("INsufficient balance.");
        }
        else{
            System.out.println("Withdrawal amount must be positive");
        }
    } 
}
