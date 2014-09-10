package jbowden.support;

public enum WeekDay {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String name;

    private WeekDay(String name) {
        this.name = name;
    }

    public int getIndex() {
        return ordinal();
    }

    @Override
    public String toString() {
        return name;
    }

    public static WeekDay fromIndex(int index) {
        return WeekDay.values()[index];
    }
}