public class Chap5_7 {
    public static void main(String[] args) {
        // Evaluate and print expressions from Exercise 5.7
        double a = Math.abs(7.5); 
        double b = Math.floor(7.5); 
        double c = Math.abs(0.0); 
        double d = Math.ceil(0.0); 
        double e = Math.abs(-6.4); 
        double f = Math.ceil(-6.4); 
        double g = Math.ceil(-Math.abs(-8 + Math.floor(-5.5)));

        System.out.printf("a) Math.abs(7.5)   = %.1f%n", a);
        System.out.printf("b) Math.floor(7.5) = %.1f%n", b);
        System.out.printf("c) Math.abs(0.0)   = %.1f%n", c);
        System.out.printf("d) Math.ceil(0.0)  = %.1f%n", d);
        System.out.printf("e) Math.abs(-6.4)  = %.1f%n", e);
        System.out.printf("f) Math.ceil(-6.4) = %.1f%n", f);
        System.out.printf("g) Complex layout  = %.1f%n", g);
    }
}