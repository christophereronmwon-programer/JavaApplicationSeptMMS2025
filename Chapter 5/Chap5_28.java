import java.util.Scanner;

public class Chap5_28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter student's average score (0-100): ");
        int average = input.nextInt();
        
        int points = qualityPoints(average);
        System.out.printf("Quality points assigned: %d%n", points);
        
        input.close();
    }
    
    public static int qualityPoints(int average) {
        if (average >= 90 && average <= 100) return 4;
        if (average >= 80 && average <= 89)  return 3;
        if (average >= 70 && average <= 79)  return 2;
        if (average >= 60 && average <= 69)  return 1;
        return 0;
    }
}