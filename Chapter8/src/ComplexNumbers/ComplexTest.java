
package ComplexNumbers;



public class ComplexTest {

    public static void main(String[] args) {

        Complex c1 = new Complex(5,3);
        Complex c2 = new Complex(2,4);

        Complex sum = c1.add(c2);
        Complex difference = c1.subtract(c2);

        System.out.println("First Number : " + c1);
        System.out.println("Second Number: " + c2);

        System.out.println();

        System.out.println("Addition : " + sum);
        System.out.println("Subtraction : " + difference);

    }

}