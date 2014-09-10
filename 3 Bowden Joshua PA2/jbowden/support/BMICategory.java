package jbowden.support;

/**
 * Represents the BMI weight categories.
 */
public enum BMICategory {
    UNDERWEIGHT("Underweight", Double.NEGATIVE_INFINITY, 18.5),
    NORMAL("Normal", 18.5, 25.0),
    OVERWEIGHT("Overweight", 25.0, 29.9),
    OBESE("Obese", 30.0, Double.POSITIVE_INFINITY);

    private String name;

    /**
     * The lower range of the weight category (inclusive)
     */
    private double lower;

    /**
     * The upper range of the weight category (exclusive)
     */
    private double upper;

    BMICategory(String name, double lower, double upper) {
        this.name = name;
        this.lower = lower;
        this.upper = upper;
    }

    public static BMICategory fromBMI(double bmi) {
        for (BMICategory category : BMICategory.values()) {
            if (category.contains(bmi)) return category;
        }

        // In the case that no category was matched (which should never happen)
        throw new IllegalStateException("Unable to represent weight as a BMI category.");
    }

    public boolean contains(double weight) {
        return weight >= lower && weight < upper;
    }

    public String getName() {
        return name;
    }
}
