package jbowden.assignments;

import jbowden.support.DayOfWeekCalculator;
import jbowden.support.WeekDay;

import java.util.Scanner;

public class DayOfWeek {

    public static void main(String[] args) {
        new DayOfWeek().run();
    }

    private final Scanner scanner;

    public DayOfWeek() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.print("Enter the day: ");
        final int day = scanner.nextInt();

        System.out.print("Enter the month (1-12): ");
        final int month = scanner.nextInt();

        System.out.print("Enter the year (4 digits): ");
        final int year = scanner.nextInt();

        final WeekDay weekDay = new DayOfWeekCalculator(day, month, year).getWeekDay();
        System.out.printf("Day is %s (%d)\n", weekDay.toString(), weekDay.getIndex());
    }
}

