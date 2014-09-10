package jbowden;

import jbowden.Prompt;
import java.util.Scanner;

public class Prompter<T> {
    private final Scanner scanner;
    private final Prompt<T> prompt;

    public Prompter(Prompt<T> prompt, Scanner scanner) {
        this.scanner = scanner;
        this.prompt = prompt;
    }
    
    public T prompt() {
        return promptRaw(null);
    }
    
    public void dispose() {
        scanner.close();
    }
    
    private T promptRaw(Exception e) {
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
            return promptRaw(ex);
        }
        
        return value;
    }
}
