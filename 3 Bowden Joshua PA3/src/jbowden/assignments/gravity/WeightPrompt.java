package jbowden.assignments.gravity;

import jbowden.prompting.ScannerPrompt;

import java.util.InputMismatchException;
import java.util.Scanner;

class WeightPrompt extends ScannerPrompt<Double> {
    public WeightPrompt(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void onPrompt() {
        System.out.print("Enter your weight: ");
    }

    @Override
    public Double onInput() {
        final double weight = scanner.nextDouble();

        if (weight < 0) {
            throw new InputMismatchException("A weight cannot be negative.");
        }

        return weight;
    }

    @Override
    public void onError(Exception e) {
        System.out.printf("Invalid weight: %s\n", e.getMessage());
    }
}