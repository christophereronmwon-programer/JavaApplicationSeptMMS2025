public class IncrementDemo {
    public static void main(String[] args) {
        int a = 5;

        System.out.println("Preincrement: " + (++a)); // increments first
        a = 5;
        System.out.println("Postincrement: " + (a++)); // uses then increments
        System.out.println("Value after postincrement: " + a);
    }
}
