package jbowden.assignments; /**
 * Class Count
 * 
 */
import jbowden.prompting.Prompter;
import jbowden.prompting.ScannerPrompt;

import java.util.*;

public class Count
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputScores = getInputScores(scanner);
        final Map<ScoreCategory, List<Integer>> categorizedScores = categorizeScores(inputScores);

        printCategoryCountMessage(categorizedScores);
        printAverage(inputScores);
        System.out.println();
        System.out.println("HISTOGRAM:\n");
        printHistogram(categorizedScores);
    }

    private static List<Integer> getInputScores(Scanner scanner) {
        List<Integer> inputScores = new ArrayList<Integer>();

        while (true) {
            Integer input = Prompter.getInstance().prompt(scanner, new ScorePrompt(scanner));

            // If a negative number was input then quit inputting values
            if (input < 0) {
                break;
            }

            inputScores.add(input);
        }
        return inputScores;
    }

    private static void printAverage(List<Integer> inputScores) {
        final double average = average(inputScores);
        System.out.printf("\nThe average of the %d scores is %.1f\n", inputScores.size(), average);
    }

    private static void printHistogram(Map<ScoreCategory, List<Integer>> categorizedScores) {
        final int maxNameLength = getCategoryNameMaxWidth();
        for (Map.Entry<ScoreCategory, List<Integer>> entry : categorizedScores.entrySet()) {
            System.out.printf("%" + maxNameLength + "s |", entry.getKey().getName().toLowerCase());

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print("X");
            }
        }
    }

    private static int getCategoryNameMaxWidth() {
        int maxNameWidth = 0;
        for (ScoreCategory category : ScoreCategory.values()) {
            final int length = category.getName().length();

            if (length > maxNameWidth) {
                maxNameWidth = length;
            }
        }

        return maxNameWidth;
    }

    private static void printCategoryCountMessage(Map<ScoreCategory, List<Integer>> categorizedScores) {
        System.out.print("\nThere were ");

        final int CATEGORIES_COUNT = categorizedScores.keySet().size();
        int i = 0;

        for (Map.Entry<ScoreCategory, List<Integer>> entry : categorizedScores.entrySet()) {
            if (i > 0 && i < CATEGORIES_COUNT - 1) {
                System.out.print(", ");
            } else if (i == CATEGORIES_COUNT - 1) {
                System.out.print(", and ");
            }

            System.out.printf("%d %s scores", entry.getValue().size(), entry.getKey().getName());

            if (i == CATEGORIES_COUNT - 1) {
                System.out.print(".");
            }

            i++;
        }
    }

    private static Map<ScoreCategory, List<Integer>> categorizeScores(List<Integer> scores) {
        final Map<ScoreCategory, List<Integer>> map = new HashMap<ScoreCategory, List<Integer>>();

        // Inset initial values with blank lists
        for (ScoreCategory category : ScoreCategory.values()) {
            map.put(category, new ArrayList<Integer>());
        }

        for (Integer score : scores) {
            final ScoreCategory category = ScoreCategory.fromScore(score);
            final List<Integer> currentScores = map.get(category);
            currentScores.add(score);
        }

        return map;
    }

    private static double average(List<Integer> scores) {
        int total = 0;

        for (Integer score : scores) {
            total += score;
        }

        return (double) total / (double) scores.size();
    }
}

class ScorePrompt extends ScannerPrompt<Integer> {
    ScorePrompt(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void onPrompt() {
        System.out.print("Enter a score (negative to exit): ");
    }

    @Override
    public Integer onInput() {
        return scanner.nextInt();
    }

    @Override
    public void onError(Exception e) {
        System.out.println("Invalid input: " + e.getMessage());
    }
}

/**
 * Represents the score categories.
 */
enum ScoreCategory {
    HIGH("HIGH", 100, 150, false),
    MIDDLE("MIDDLE", 60, 100, false),
    LOW("LOW", 0, 60, false);

    private final String name;

    /**
     * The lower range of the score
     */
    private final int lower;

    /**
     * The upper range of the score
     */
    private final int upper;
    private final boolean isUpperRangeInclusive;

    ScoreCategory(String message, int lower, int upper, boolean isUpperRangeInclusive) {
        this.name = message;
        this.lower = lower;
        this.upper = upper;
        this.isUpperRangeInclusive = isUpperRangeInclusive;
    }

    public static ScoreCategory fromScore(int score) {
        for (ScoreCategory category : ScoreCategory.values()) {
            if (category.contains(score)) return category;
        }

        // In the case that no category was matched (which should never happen)
        throw new IllegalStateException("Unable to represent score as a category.");
    }

    public boolean contains(double gpa) {
        if (isUpperRangeInclusive) {
            return gpa >= lower && gpa < upper;
        } else {
            return gpa >= lower && gpa <= upper;
        }
    }

    public String getName() {
        return name;
    }
}
