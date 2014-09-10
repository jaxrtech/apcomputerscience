package jbowden.assignments.tax;

import jbowden.prompting.Prompt;
import jbowden.prompting.Prompter;

import java.util.*;

class TaxProgram implements Runnable {
    private final Scanner scanner = new Scanner(System.in);

    private final Set<TaxRule> rules = new HashSet<TaxRule>();

    {
        rules.add(new TaxRule("1",    0.00,  1500.00,    0.00, 0.15));
        rules.add(new TaxRule("2", 1500.00,  2500.00,  255.00, 0.16));
        rules.add(new TaxRule("3", 3000.00,  5000.00,  465.00, 0.18));
        rules.add(new TaxRule("4", 5000.00,  8000.00,  825.00, 0.20));
        rules.add(new TaxRule("5", 8000.00, 15000.00, 1425.00, 0.25));
    }

    @Override
    public void run() {
        double salary = Prompter.getInstance().prompt(scanner, new Prompt<Double>() {
            @Override
            public void onPrompt() {
                System.out.print("Enter your salary in dollars: ");
            }

            @Override
            public Double onInput() {
                final double salary = scanner.nextDouble();

                if (salary < 0) {
                    throw new InputMismatchException("Salary cannot be negative.");
                }

                return salary;
            }

            @Override
            public void onError(Exception e) {
                System.out.printf("Invalid input: %s\n", e.getMessage());
            }
        });

        final double cost = new TaxCalculator(salary, rules).getTaxDue();
        System.out.printf("The total tax due is $%.2f\n", cost);
    }
}
