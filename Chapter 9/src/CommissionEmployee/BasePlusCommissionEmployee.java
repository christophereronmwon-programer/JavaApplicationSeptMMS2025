
package CommissionEmployee;


public class BasePlusCommissionEmployee {

    private CommissionEmployee employee;
    private double baseSalary;

    public BasePlusCommissionEmployee(
            CommissionEmployee employee,
            double baseSalary) {

        this.employee = employee;
        this.baseSalary = baseSalary;
    }

    public double earnings() {

        return employee.earnings() + baseSalary;

    }

    @Override
    public String toString() {

        return employee.toString()
                + "\nBase Salary: " + baseSalary
                + "\nTotal Earnings: " + earnings();
    }
}
