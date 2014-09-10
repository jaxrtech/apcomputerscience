package jbowden;

import jbowden.Prompt;
import jbowden.Prompter;
import java.util.*;

public class ObjectHeight implements Prompt<Double> {

    private static final double MAX_SECONDS = 4.5;
    
    private final Scanner scanner;
    private final Prompter<Double> prompter;
    
    public static void main(String[] args) {
        new ObjectHeight().run();
    }
    
    public ObjectHeight() {
       this.scanner = new Scanner(System.in);
       this.prompter = new Prompter<Double>(this, scanner);
    }
    
    public void run() {
        System.out.println("Object height calculator");
        final double time = prompter.prompt();
        final double height = calculateHeight(time);
        
        System.out.printf("The height of the object is: %.2f meters\n", height);
        
        prompter.dispose();
    }
    
    @Override
    public void onError(Exception e) {
        System.out.println("Error: Invalid format. Input a number less than 4.5.");
    }
    
    @Override
    public void onPrompt() {
        System.out.printf("Enter time to calculate (must be less than %.1f sec): ", MAX_SECONDS);
    }
    
    @Override
    public Double onInput() {
        final double time = scanner.nextDouble();
            
        if (time >= MAX_SECONDS) {
            throw new InputMismatchException("Time cannot be greater than or equal to the maximum time.");
        }
        
        return time;
    }
    
    private static double calculateHeight(double time) {
        return 100 - 4.9 * Math.pow(time, 2);
    }
}