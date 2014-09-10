package jbowden.assignments.telephone;

import jbowden.prompting.ScannerPrompt;

import java.util.Scanner;

class TimePrompt extends ScannerPrompt<Time> {
    private final String promptText;

    TimePrompt(Scanner scanner, String promptText) {
        super(scanner);
        this.promptText = promptText;
    }

    @Override
    public void onError(Exception e) {
        if (e != null) {
            System.out.printf("Error: %s. Try again.\n", e.getMessage());
        }
    }

    @Override
    public void onPrompt() {
        System.out.printf(promptText);
    }

    @Override
    public Time onInput() {
        final int formattedTime = scanner.nextInt();
        final int hours = formattedTime / 100;
        final int minutes = formattedTime % 100;

        if (formattedTime < 0) {
            throw new IllegalStateException("Given time cannot be negative");
        }

        if (formattedTime > 2400) {
            throw new IllegalStateException("Given time cannot be greater than 2400 hours");
        }

        if (hours > 24) {
            throw new IllegalStateException("The number of hours must be between 0 and 24");
        }

        if (minutes > 59) {
            throw new IllegalStateException("The number of minutes must be between 0 and 60");
        }

        return new Time(hours, minutes);
    }
}
