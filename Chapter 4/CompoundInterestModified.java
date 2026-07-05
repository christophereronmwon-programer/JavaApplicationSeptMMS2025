public class CompoundInterestModified {
    public static void main(String[] args) {

        double principal = 1000.0;
        int years = 10;

        System.out.printf("%-10s", "Year");

        
        for (int rate = 5; rate <= 10; rate++) {
            System.out.printf("%-15s%%", rate);
        }

        System.out.println();

      
        for (int year = 1; year <= years; year++) {
            System.out.printf("%-10d", year);

           
            for (int rate = 5; rate <= 10; rate++) {
                double interestRate = rate / 100.0;
                double amount = principal * Math.pow(1 + interestRate, year);

                System.out.printf("%-15.2f", amount);
            }

            System.out.println();
        }
    }
}