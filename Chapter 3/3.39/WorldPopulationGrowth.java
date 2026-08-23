import java.util.Scanner;

public class WorldPopulationGrowth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter current world population: ");
        double currentPopulation = input.nextDouble();

        System.out.print("Enter annual growth rate (as %): ");
        double growthRate = input.nextDouble() / 100;

        System.out.println("Year\tPopulation\tIncrease");

        for (int year = 1; year <= 75; year++) {
            double increase = currentPopulation * growthRate;
            currentPopulation += increase;
            System.out.printf("%d\t%.0f\t%.0f%n", year, currentPopulation, increase);
        }
    }
}
