package jbowden.assignments.telephone;

class Time {
    public static final int MINUTES_IN_HOUR = 60;

    private final int hours;
    private final int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public static Time fromMinutes(int minutes) {
        final int hours = minutes / MINUTES_IN_HOUR;
        minutes -= hours * MINUTES_IN_HOUR;
        return new Time(hours, minutes);
    }

    /**
     * Returns the duration between two points in time.
     * @param other  the other time to measure the duration with
     * @return a time as a duration
     */
    public Time durationTo(Time other) {
        // Must subtract 1 extra from the hours since you don't count the starting hour
        return Time.fromMinutes(other.asMinutes() - this.asMinutes());
    }

    public boolean isBetweenExclusively(Time start, Time end) {
        return (asMinutes() >= start.asMinutes() && asMinutes() < end.asMinutes());
    }

    public boolean isBetweenInclusively(Time start, Time end) {
        return asMinutes() >= start.asMinutes() && asMinutes() <= end.asMinutes();
    }

    /**
     * Returns the hours of time.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Returns the minutes of time.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Returns the number of minutes since 00:00.
     */
    public int asMinutes() {
        return hours * MINUTES_IN_HOUR + minutes;
    }

    public String toFormattedString() {
        return Integer.toString(hours) + Integer.toString(minutes);
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
