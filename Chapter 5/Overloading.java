
public class Overloading {
    public static int square(int x) { return x * x; }
    public static double square(double x) { return x * x; }

    public static void main(String[] args) {
        System.out.println("Square(5) = " + square(5));
        System.out.println("Square(3.5) = " + square(3.5));
    }
}