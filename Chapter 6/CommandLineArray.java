// 6.15 Command-Line Array Size
public class CommandLineArray {
    public static void main(String[] args) {
        int size = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        int[] array = new int[size];
        System.out.println("Array size: " + array.length);
    }
}