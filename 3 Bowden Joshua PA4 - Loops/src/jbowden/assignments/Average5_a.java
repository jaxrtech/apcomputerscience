package jbowden.assignments; /**
 * Introduce loop concepts – “the while loop”
 *
 */

import java.util.*;

public class Average5_a {

    public static final int INPUTS_COUNT = 5;

    public static void main(String[] args) {
        final Scanner console = new Scanner(System.in);

        int scoresCount = 0;
        double score = 0;
        double total = 0;

        while (scoresCount < INPUTS_COUNT) {
            System.out.print("Enter a score (0-100): ");

            try {
                score = console.nextDouble();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            if (score < 0 || score > 100) {
                System.out.println("Error: Invalid input. Score must be between 0 and 100.");
                continue;
            }

            total += score;
            scoresCount++;
        }

        final double avg = total / scoresCount;

        System.out.printf("The average is %.2f\n", avg);

        console.close();
    }
}

