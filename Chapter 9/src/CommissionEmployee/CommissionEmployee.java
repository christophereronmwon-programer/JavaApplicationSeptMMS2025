
package CommissionEmployee;

public class CommissionEmployee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName,
            String socialSecurityNumber,
            double grossSales, double commissionRate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double earnings() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {

        return "Commission Employee\n"
                + "Name: " + firstName + " " + lastName
                + "\nSSN: " + socialSecurityNumber
                + "\nGross Sales: " + grossSales
                + "\nCommission Rate: " + commissionRate;
    }
}
