package jbowden.assignments;

import jbowden.support.BMICategory;

import java.util.Scanner;

import static jbowden.support.BMI.bmi;
import static jbowden.support.UnitConversions.*;

public class BMI {
    private static Scanner scanner;

    public static void main(String[] args) {
        new BMI().run();
    }

    public BMI() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter your height:");
        System.out.print("  Feet: ");
        final int feet = scanner.nextInt();

        System.out.print("  Inches: ");
        final int inches = scanner.nextInt();

        System.out.print("Enter your weight: ");
        final double pounds = scanner.nextDouble();

        final double bmi = bmi(poundsToKilograms(pounds),
                                                   inchesToMeters(feetInchesToInches(feet, inches)));

        System.out.printf("A %d foot %d inch adult of %.1f pounds has a Body Mass Index (BMI) of %.1f\n",
                          feet, inches, pounds, bmi);

        final BMICategory category = BMICategory.fromBMI(bmi);
        System.out.printf("Their weight category is '%s'.\n", category.getName());
    }
}

