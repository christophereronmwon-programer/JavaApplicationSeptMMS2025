public class ControlStatements {
    public static void main(String[] args) {
        int x = 5;

        // Nesting example
        if (x > 0) {
            while (x < 10) {
                System.out.println("x is " + x);
                x++;
            }
        }

        // Sequential example
        if (x == 10) {
            System.out.println("x reached 10");
        }
        while (x > 0) {
            x--;
        }
    }
}
