public class Countdown {
    public static void main(String[] args) {
        int y = 10; // example starting value

        while (y > 0) {
            System.out.println(y);
            --y; // decrement instead of increment
        }
    }
}
