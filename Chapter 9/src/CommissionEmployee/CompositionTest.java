
package CommissionEmployee;


public class CompositionTest {

    public static void main(String[] args) {

        CommissionEmployee emp =
                new CommissionEmployee(
                        "John",
                        "Smith",
                        "123-45-6789",
                        10000,
                        0.06);

        BasePlusCommissionEmployee worker =
                new BasePlusComm1issionEmployee(emp,3000);

        System.out.println(worker);

    }

}