package jbowden.assignments.academicstatus;

/**
 * Represents the BMI weight categories.
 */
enum GPACategory {
    _1("Failed semester - registration suspended", 0.0, 1.0, false),
    _2("On probation next semester", 1.0, 2.00, false),
    _3("(No message)", 2.0, 3.0, false),
    _4("Dean's list for semester", 3.0, 3.5, false),
    _5("Highest honors for semester", 3.5, 4.0, true);

    private final String message;

    /**
     * The lower range of the GPA (inclusive)
     */
    private final double lower;

    /**
     * The upper range of the GPA (exclusive)
     */
    private final double upper;
    private final boolean isUpperRangeInclusive;

    GPACategory(String message, double lower, double upper, boolean isUpperRangeInclusive) {
        this.message = message;
        this.lower = lower;
        this.upper = upper;
        this.isUpperRangeInclusive = isUpperRangeInclusive;
    }

    public static GPACategory fromGPA(double gpa) {
        for (GPACategory category : GPACategory.values()) {
            if (category.contains(gpa)) return category;
        }

        // In the case that no category was matched (which should never happen)
        throw new IllegalStateException("Unable to represent GPA as a category.");
    }

    public boolean contains(double gpa) {
        if (isUpperRangeInclusive) {
            return gpa >= lower && gpa < upper;
        } else {
            return gpa >= lower && gpa <= upper;
        }
    }

    public String getMessage() {
        return message;
    }
}
