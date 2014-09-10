package jbowden.assignments.gravity;

import jbowden.prompting.Prompter;

import java.util.Scanner;

class Gravity implements Runnable {

    private final Scanner scanner = new Scanner(System.in);

    private final Prompter prompter = Prompter.getInstance();

    @Override
    public void run() {
        double weight = prompter.prompt(scanner, new WeightPrompt(scanner));
        Planet planet = prompter.prompt(scanner, new PlanetPrompt(scanner));

        double weightOnPlanet = weight * planet.getGravity();
        System.out.printf("Your weight will be %.2f pounds.\n", weightOnPlanet);
    }
}