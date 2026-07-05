import java.util.Scanner;

public class Chap6_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[10]; // seats 0-4 First Class, 5-9 Economy

        while (true) {
            System.out.print("Please type 1 for First Class and 2 for Economy (-1 to quit): ");
            int choice = input.nextInt();

            if (choice == -1) {
                break;
            }

            if (choice == 1) {
                assignSeat(seats, true, input);
            } else if (choice == 2) {
                assignSeat(seats, false, input);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void assignSeat(boolean[] seats, boolean firstClass, Scanner input) {
        int start = firstClass ? 0 : 5;
        int end = firstClass ? 5 : 10;
        int seatAssigned = -1;

        for (int i = start; i < end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                seatAssigned = i + 1;
                break;
            }
        }

        if (seatAssigned != -1) {
            displayBoardingPass(seatAssigned, firstClass);
        } else {
            String alternativeSection = firstClass ? "Economy" : "First Class";
            System.out.printf("The %s section is full. Switch to %s? (Y/N): ", 
                              firstClass ? "First Class" : "Economy", alternativeSection);
            char response = input.next().toUpperCase().charAt(0);

            if (response == 'Y') {
                assignSeat(seats, !firstClass, input);
            } else {
                System.out.println("Next flight leaves in 3 hours.");
            }
        }
    }

    private static void displayBoardingPass(int seatNumber, boolean firstClass) {
        System.out.println("\n---------------------------------");
        System.out.println("          BOARDING PASS          ");
        System.out.printf("  Seat Number: %d%n", seatNumber);
        System.out.printf("  Section: %s%n", firstClass ? "First Class" : "Economy");
        System.out.println("---------------------------------\n");
    }
}