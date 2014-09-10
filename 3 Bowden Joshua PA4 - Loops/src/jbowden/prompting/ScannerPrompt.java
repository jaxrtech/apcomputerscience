package jbowden.prompting;

import java.util.Scanner;

public abstract class ScannerPrompt<T> implements Prompt<T> {
    protected final Scanner scanner;

    protected ScannerPrompt(Scanner scanner) {
        this.scanner = scanner;
    }
}
