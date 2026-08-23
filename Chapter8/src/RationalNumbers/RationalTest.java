
package RationalNumbers;


public class RationalTest {

    public static void main(String[] args) {

        Rational r1=new Rational(2,4);

        Rational r2=new Rational(3,5);

        System.out.println("First = "+r1);

        System.out.println("Second = "+r2);

        System.out.println("Add = "
                +Rational.add(r1,r2));

        System.out.println("Subtract = "
                +Rational.subtract(r1,r2));

        System.out.println("Multiply = "
                +Rational.multiply(r1,r2));

        System.out.println("Divide = "
                +Rational.divide(r1,r2));

        System.out.println("Decimal = "
                +r1.toFloatingPoint());

    }

}
