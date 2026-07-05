public class Chap6_16 {
    public static void main(String[] args) {
        double sum = 0.0;

        for (String arg : args) {
            sum += Double.parseDouble(arg);
        }

        System.out.printf("The sum of command-line arguments is: %.2f%n", sum);
    }
}