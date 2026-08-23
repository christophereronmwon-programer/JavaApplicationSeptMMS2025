import java.util.Random;

public class AccountNumberGenerator {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate a random 7-digit number
        int randomPart = 1000000 + random.nextInt(9000000);

        // Prefix with three zeros
        String accountNumber = "000" + randomPart;

        System.out.println("Account Number: " + accountNumber);
    }
}