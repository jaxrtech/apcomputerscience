package jbowden.support;

public class UnitConversions {
    public static double feetInchesToInches(double feet, double inches) {
        final int inchesPerFoot = 12;
        return feet * inchesPerFoot + inches;
    }

    public static double inchesToMeters(double inches) {
        final double metersPerInch = 2.54e-2;
        return inches * metersPerInch;
    }

    public static double poundsToKilograms(double pounds) {
        final double kilogramsPerPound = 2.2;
        return pounds / kilogramsPerPound;
    }
}
