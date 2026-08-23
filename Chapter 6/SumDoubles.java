// 6.16 Enhanced For Statement
public class SumDoubles {
    public static void main(String[] args) {
        double sum = 0;
        for (String arg : args) sum += Double.parseDouble(arg);
        System.out.println("Sum = " + sum);
    }
}