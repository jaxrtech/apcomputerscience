// Nutrition 1
// AP Computer Science
// Exam #1
// Fall 2013

import java.util.*;

public class Nutrition1
{
    private static final double CALORIES_PER_GRAM_PROTEIN = 4.0;
    private static final double CALORIES_PER_GRAM_CARBO = 4.0;
    private static final double CALORIES_PER_GRAM_FAT = 9.0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the following nutritional information.\n");

        System.out.print("How many grams of protein? ");
        final double proteinGrams = scanner.nextDouble();

        System.out.print("How many grams of carbohydrate? ");
        final double carboGrams = scanner.nextDouble();

        System.out.print("How many grams of fat? ");
        final double fatGrams = scanner.nextDouble();

        // Calculations

        final double totalGrams = proteinGrams + carboGrams + fatGrams;

        final double percentProtein = (proteinGrams / totalGrams) * 100.0;
        final double percentCarbo = (carboGrams / totalGrams) * 100.0;
        final double percentFat = (fatGrams / totalGrams) * 100.0;

        final double protienCalories = proteinGrams * CALORIES_PER_GRAM_PROTEIN;
        final double carboCalories = carboGrams * CALORIES_PER_GRAM_CARBO;
        final double fatCalories = fatGrams * CALORIES_PER_GRAM_FAT;

        final double totalCals = protienCalories + carboCalories + fatCalories;

        // output the results
        System.out.println("\nPercentage Composition:");
        System.out.printf("Percent Protein = %.1f \n", percentProtein);
        System.out.printf("Percent Carb    = %.1f \n", percentCarbo);
        System.out.printf("Percent Fat     = %.1f \n\n", percentFat);

        System.out.printf("Total Calories   = %.1f\n", totalCals);
        System.out.printf("Calories from fat= %.1f\n", fatCalories);
    }
}