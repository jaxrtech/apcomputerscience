package jbowden.assignments.gravity;

import jbowden.prompting.ScannerPrompt;

import java.util.Scanner;

class PlanetPrompt extends ScannerPrompt<Planet> {
    public PlanetPrompt(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void onPrompt() {
        printPlanetsList();
        System.out.print("Which planet? ");
    }

    private void printPlanetsList() {
        final int maxNameWidth = getPlanetNameMaxWidth();

        int i = 1;
        for (Planet planet : Planet.values()) {
            final String planetName = planet.getName();
            final String nameCell = String.format("%-" + maxNameWidth + "s", planetName);
            System.out.printf(" %d = %s", i, nameCell);

            // 3 per line
            if (i % 3 == 0) {
                System.out.print('\n');
            }

            i++;
        }
    }

    private int getPlanetNameMaxWidth() {
        int maxNameWidth = 0;
        for (Planet planet : Planet.values()) {
            final int length = planet.getName().length();

            if (length > maxNameWidth) {
                maxNameWidth = length;
            }
        }

        return maxNameWidth;
    }

    @Override
    public Planet onInput() {
        final int index = scanner.nextInt();

        try {
            // Subtract 1 since the index is 0-indexed
            return Planet.fromIndex(index - 1);
        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("The index is invalid.");
        }
    }

    @Override
    public void onError(Exception e) {
        System.out.printf("Invalid planet: %s\n", e.getMessage());
    }
}
