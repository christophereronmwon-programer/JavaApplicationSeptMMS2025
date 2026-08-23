
package ComplexNumbers;


public class Complex {

    private double real;
    private double imaginary;

    public Complex(){

        real = 0;
        imaginary = 0;
    }

    public Complex(double real,double imaginary){

        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other){

        return new Complex(
                real + other.real,
                imaginary + other.imaginary);
    }

    public Complex subtract(Complex other){

        return new Complex(
                real - other.real,
                imaginary - other.imaginary);
    }

    @Override
    public String toString(){

        return "(" + real + ", " + imaginary + ")";

    }

}
