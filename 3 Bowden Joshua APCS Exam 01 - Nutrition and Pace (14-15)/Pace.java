
// Pace
// AP Computer Science
// Exam #1
// Fall 2014

import java.util.Scanner;

public class Pace
{
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_MINUTE = 60;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many miles was the race? ");
        final double miles = scanner.nextDouble();

        System.out.print("Enter the total race time as a 4 digit integer (in the format HHMM): ");
        final int raceTime = scanner.nextInt();
        final int minutes = raceTime % 100;
        final int hours = (raceTime - minutes) / 100;
        final int totalMinutes = (MINUTES_PER_HOUR * hours) + minutes;

        final double minsPerMile = (double) totalMinutes / miles;
        final double secsPerMile = minsPerMile * SECONDS_PER_MINUTE;
        final int mins = (int) (secsPerMile / SECONDS_PER_MINUTE);
        final double secs = secsPerMile - (mins * SECONDS_PER_MINUTE);

        // Display the page as MM:SS per mile
        System.out.printf("\nYour pace is %.4f minutes per mile. Which is equivalent to a pace of\n", minsPerMile);
        System.out.printf("\n%02d minutes %.2f seconds per mile.\n", mins, secs);
    }
}
