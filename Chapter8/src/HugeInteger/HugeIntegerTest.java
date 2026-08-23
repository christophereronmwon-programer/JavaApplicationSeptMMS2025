
package HugeInteger;


public class HugeIntegerTest {

    public static void main(String[] args) {

        HugeInteger num1 = new HugeInteger();
        HugeInteger num2 = new HugeInteger();

        num1.parse("12345678901234567890");
        num2.parse("9876543210");

        System.out.println("Number 1 = " + num1);
        System.out.println("Number 2 = " + num2);

        HugeInteger sum = num1.add(num2);

        System.out.println("Addition = " + sum);

        HugeInteger difference = num1.subtract(num2);

        System.out.println("Subtraction = " + difference);

        System.out.println();

        System.out.println("Equal? " + num1.isEqualTo(num2));
        System.out.println("Not Equal? " + num1.isNotEqualTo(num2));
        System.out.println("Greater? " + num1.isGreaterThan(num2));
        System.out.println("Less? " + num1.isLessThan(num2));
        System.out.println("Greater or Equal? " +
                num1.isGreaterThanOrEqualTo(num2));
        System.out.println("Less or Equal? " +
                num1.isLessThanOrEqualTo(num2));

        HugeInteger zero = new HugeInteger();

        System.out.println("Zero object = " + zero);
        System.out.println("Is Zero? " + zero.isZero());

    }

}
