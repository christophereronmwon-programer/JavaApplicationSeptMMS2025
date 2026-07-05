import java.util.Scanner;

public class GlobalWarmingQuiz {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("=== GLOBAL WARMING QUIZ ===\n");

        // QUESTION 1
        System.out.println("1. What is the main gas linked to human-driven global warming?");
        System.out.println("1. Oxygen");
        System.out.println("2. Carbon Dioxide");
        System.out.println("3. Nitrogen");
        System.out.println("4. Helium");
        System.out.print("Answer: ");
        int q1 = input.nextInt();
        if (q1 == 2) score++;

        System.out.println();

        // QUESTION 2
        System.out.println("2. Which activity contributes most to CO2 emissions?");
        System.out.println("1. Volcanic eruptions");
        System.out.println("2. Solar flares");
        System.out.println("3. Burning fossil fuels");
        System.out.println("4. Earthquakes");
        System.out.print("Answer: ");
        int q2 = input.nextInt();
        if (q2 == 3) score++;

        System.out.println();

        // QUESTION 3
        System.out.println("3. What is a common argument made by climate change skeptics?");
        System.out.println("1. Climate change is entirely man-made");
        System.out.println("2. Climate has always changed naturally");
        System.out.println("3. CO2 has no effect on temperature");
        System.out.println("4. Ice age is ending soon");
        System.out.print("Answer: ");
        int q3 = input.nextInt();
        if (q3 == 2) score++;

        System.out.println();

        // QUESTION 4
        System.out.println("4. What is a widely accepted effect of global warming?");
        System.out.println("1. Global cooling everywhere");
        System.out.println("2. Sea level rise");
        System.out.println("3. No weather changes");
        System.out.println("4. Decrease in sunlight");
        System.out.print("Answer: ");
        int q4 = input.nextInt();
        if (q4 == 2) score++;

        System.out.println();

        // QUESTION 5
        System.out.println("5. What organization publishes major climate assessment reports?");
        System.out.println("1. NASA");
        System.out.println("2. FIFA");
        System.out.println("3. IPCC");
        System.out.println("4. WHO");
        System.out.print("Answer: ");
        int q5 = input.nextInt();
        if (q5 == 3) score++;

        System.out.println("\n=== RESULTS ===");
        System.out.println("Score: " + score + "/5");

        if (score == 5) {
            System.out.println("Excellent");
        } 
        else if (score == 4) {
            System.out.println("Very good");
        } 
        else {
            System.out.println("Time to brush up on your knowledge of global warming");

            System.out.println("\nSuggested websites:");
            System.out.println("- https://www.ipcc.ch");
            System.out.println("- https://climate.nasa.gov");
            System.out.println("- https://www.noaa.gov/climate");
            System.out.println("- https://royalsociety.org/topics-policy/projects/climate-change/");
        }

        input.close();
    }
}