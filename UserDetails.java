import java.util.Scanner;

public class UserDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name, address;
        int age;

        // Accept user input
        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter your age: ");
        age = input.nextInt();
        input.nextLine(); // clears buffer

        System.out.print("Enter your address: ");
        address = input.nextLine();

        // Display meaningful message
        System.out.println("\n----- USER DETAILS -----");
        System.out.println("Hello " + name + "!");
        System.out.println("You are " + age + " years old.");
        System.out.println("You live at " + address + ".");
        System.out.println("Thank you for providing your details.");

        input.close();
    }
}