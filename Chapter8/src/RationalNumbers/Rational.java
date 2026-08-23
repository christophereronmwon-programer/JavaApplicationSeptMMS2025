
package RationalNumbers;


public class Rational {

    private int numerator;
    private int denominator;

    public Rational(){

        numerator=0;
        denominator=1;
    }

    public Rational(int numerator,int denominator){

        this.numerator=numerator;
        this.denominator=denominator;

        reduce();
    }

    private void reduce(){

        int gcd=1;

        for(int i=1;i<=Math.min(
                Math.abs(numerator),
                Math.abs(denominator));i++)

            if(numerator%i==0 &&
                    denominator%i==0)
                gcd=i;

        numerator/=gcd;
        denominator/=gcd;
    }

    public static Rational add(
            Rational a,Rational b){

        return new Rational(

                a.numerator*b.denominator+

                        b.numerator*a.denominator,

                a.denominator*b.denominator

        );

    }

    public static Rational subtract(
            Rational a,Rational b){

        return new Rational(

                a.numerator*b.denominator-

                        b.numerator*a.denominator,

                a.denominator*b.denominator

        );

    }

    public static Rational multiply(
            Rational a,Rational b){

        return new Rational(

                a.numerator*b.numerator,

                a.denominator*b.denominator

        );

    }

    public static Rational divide(
            Rational a,Rational b){

        return new Rational(

                a.numerator*b.denominator,

                a.denominator*b.numerator

        );

    }

    @Override
    public String toString(){

        return numerator+"/"+denominator;

    }

    public String toFloatingPoint(){

        return String.format("%.2f",

                (double)numerator/denominator);

    }

}
