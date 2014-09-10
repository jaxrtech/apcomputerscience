package jbowden.prompting;

import java.util.Scanner;

public class Prompter {
    private static Prompter ourInstance = new Prompter();

    public static Prompter getInstance() {
        return ourInstance;
    }

    private Prompter() {
    }

    public <T> T prompt(Scanner scanner, Prompt<T> prompt) {
        return promptRaw(prompt, scanner, null);
    }

    private <T> T promptRaw(Prompt<T> prompt, Scanner scanner, Exception e) {
        if (e != null) {
            prompt.onError(e);
        }

        prompt.onPrompt();

        T value;
        try {
            value = prompt.onInput();
        } catch (Exception ex) {
            // Read to the end of the line to prevent a stack overflow because `mextDouble()` will
            // not consume the next line.
            scanner.nextLine();
            return promptRaw(prompt, scanner, ex);
        }

        return value;
    }
}
