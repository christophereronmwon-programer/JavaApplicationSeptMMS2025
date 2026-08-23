
import java.util.Scanner;

public class SalesCommission {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ranges = new int[9]; // counters for salary ranges

        System.out.print("Enter number of salespeople: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter gross sales for salesperson " + (i+1) + ": ");
            double sales = input.nextDouble();
            int salary = (int)(200 + 0.09 * sales);

            if (salary >= 1000) ranges[8]++;
            else ranges[(salary - 200) / 100]++;
        }

        System.out.println("Salary Range\tNumber of Salespeople");
        System.out.println("$200–299\t" + ranges[0]);
        System.out.println("$300–399\t" + ranges[1]);
        System.out.println("$400–499\t" + ranges[2]);
        System.out.println("$500–599\t" + ranges[3]);
        System.out.println("$600–699\t" + ranges[4]);
        System.out.println("$700–799\t" + ranges[5]);
        System.out.println("$800–899\t" + ranges[6]);
        System.out.println("$900–999\t" + ranges[7]);
        System.out.println("$1000 and over\t" + ranges[8]);
    }
}