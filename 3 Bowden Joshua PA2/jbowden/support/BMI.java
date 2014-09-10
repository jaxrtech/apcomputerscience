package jbowden.support;

public class BMI {
    public static double bmi(double massKilograms, double heightMeters) {
        return massKilograms / Math.pow(heightMeters, 2);
    }
}

