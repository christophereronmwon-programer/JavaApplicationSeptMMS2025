import java.util.Scanner;

public class Chap6_33 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] topics = {
            "Global Climate Change",
            "Artificial Intelligence Safety",
            "Income Inequality",
            "Access to Clean Water",
            "Public Education Quality"
        };
        
        int[][] responses = new int[5][10]; // 5 topics, 10 options per ranking index

        System.out.print("Enter number of users taking part in the poll: ");
        int totalUsers = input.nextInt();

        for (int user = 1; user <= totalUsers; user++) {
            System.out.printf("%nRespondent %d:%n", user);
            for (int topic = 0; topic < topics.length; topic++) {
                System.out.printf("Rate standard urgency for [%s] (1-10): ", topics[topic]);
                int rating = input.nextInt();
                if (rating >= 1 && rating <= 10) {
                    responses[topic][rating - 1]++;
                } else {
                    System.out.println("Invalid weight skipped.");
                    topic--; // Repeat iteration index step safely
                }
            }
        }

        // Print header summary
        System.out.printf("%n%-32s", "Social Issues Topics");
        for (int i = 1; i <= 10; i++) System.out.printf("%4d", i);
        System.out.printf("%10s%n", "Average");

        int highestPoints = -1, lowestPoints = Integer.MAX_VALUE;
        String highestTopic = "", lowestTopic = "";

        for (int topic = 0; topic < topics.length; topic++) {
            System.out.printf("%-32s", topics[topic]);
            int pointSum = 0;
            
            for (int rating = 0; rating < 10; rating++) {
                System.out.printf("%4d", responses[topic][rating]);
                pointSum += responses[topic][rating] * (rating + 1);
            }

            double average = (double) pointSum / totalUsers;
            System.out.printf("%10.2f%n", average);

            if (pointSum > highestPoints) {
                highestPoints = pointSum;
                highestTopic = topics[topic];
            }
            if (pointSum < lowestPoints) {
                lowestPoints = pointSum;
                lowestTopic = topics[topic];
            }
        }

        System.out.printf("%nHighest Total Score: %s (%d points)%n", highestTopic, highestPoints);
        System.out.printf("Lowest Total Score:  %s (%d points)%n", lowestTopic, lowestPoints);
    }
}