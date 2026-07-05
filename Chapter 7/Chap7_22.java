import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Chap7_22 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter birth month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter birth day (1-31): ");
        int day = input.nextInt();

        System.out.print("Enter birth year (e.g., 1995): ");
        int year = input.nextInt();

        // Calculate metrics procedurally
        int age = calculateAge(year, month, day);
        int maxHeartRate = calculateMaxHeartRate(age);
        
        int targetMin = (int) (maxHeartRate * 0.50);
        int targetMax = (int) (maxHeartRate * 0.85);

        // Display Profile output
        System.out.println("\n--- Health Profile Report ---");
        System.out.printf("Name: %s %s\n", firstName, lastName);
        System.out.printf("Date of Birth: %02d/%02d/%d\n", month, day, year);
        System.out.printf("Age: %d years old\n", age);
        System.out.printf("Maximum Heart Rate: %d bpm\n", maxHeartRate);
        System.out.printf("Target Heart Rate Range (50%% - 85%%): %d bpm - %d bpm\n", targetMin, targetMax);
    }

    public static int calculateAge(int year, int month, int day) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public static int calculateMaxHeartRate(int age) {
        return 220 - age;
    }
}