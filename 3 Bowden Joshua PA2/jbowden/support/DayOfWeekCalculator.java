package jbowden.support;

public class DayOfWeekCalculator {

    /**
     * Since we are starting with 1 March, 1600 and it is a Wednesday (3)
     */
    private final int BASE_DAY_OFFSET = 3;

    private final int DAYS_IN_WEEK = 7;

    private final int MONTHS_IN_YEAR = 12;

    private final int day;
    private final int month;
    private final int year;

    public DayOfWeekCalculator(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getWeekDayIndex() {
        int wy = calculateDaysOffsetFromYear();
        int wm = calculateDaysOffsetFromMonth();
        int wd = calculateDaysOffsetFromDays();

        return (wy + wm + wd) % DAYS_IN_WEEK;
    }

    public WeekDay getWeekDay() {
        return WeekDay.fromIndex(getWeekDayIndex());
    }

    private int calculateDaysOffsetFromYear() {
        // We should be using integer division here.
        final int yearOffset = (BASE_DAY_OFFSET + year + (year / 4) - (year / 100) + (year / 400)) % DAYS_IN_WEEK;

        // If the month is less than March (3) then we need to subtract a year
        final int monthCalendarOffset = (month < 3) ? -1 : 0;

        return yearOffset + monthCalendarOffset;
    }

    private int calculateDaysOffsetFromMonth() {
        // TODO: Ask where we got his `9` from
        int monthPrime = (month + 9) % MONTHS_IN_YEAR;

        // Use the derived formula to get the cumulative offset in days from the months
        return (int)(Math.floor(2.6 * monthPrime * 0.5) % DAYS_IN_WEEK);
    }

    private int calculateDaysOffsetFromDays() {
        // We are making the days relative to the 1st day in the month (the 1st is `0`)
        return day - 1;
    }
}