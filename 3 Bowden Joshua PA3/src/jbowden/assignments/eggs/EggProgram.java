package jbowden.assignments.eggs;

import jbowden.prompting.Prompt;
import jbowden.prompting.Prompter;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class EggProgram implements Runnable {
    private final Scanner scanner = new Scanner(System.in);

    private final Set<EggRule> rules = new HashSet<EggRule>();

    {
        rules.add(new EggRule(0, 4, 0.50));
        rules.add(new EggRule(4, 6, 0.45));
        rules.add(new EggRule(6, 11, 0.48));
        rules.add(new EggRule(11, Double.POSITIVE_INFINITY, 0.35));
    }

    public void run() {
        final int eggsCount = Prompter.getInstance().prompt(scanner, new Prompt<Integer>() {
            @Override
            public void onPrompt() {
                System.out.printf("How many eggs are you purchasing? ");
            }

            @Override
            public Integer onInput() {
                final int eggs = scanner.nextInt();

                if (eggs < 0) {
                    throw new IllegalStateException("The number of eggs cannot be negative.");
                }

                return eggs;
            }

            @Override
            public void onError(Exception e) {
                if (e != null) {
                    System.out.printf("Error: %s Try again.\n", e.getMessage());
                }
            }
        });

        final double cost = new CostCalculator(rules).getTotalCost(eggsCount);
        System.out.printf("The bill is equal to: $%.2f", cost);
    }
}

