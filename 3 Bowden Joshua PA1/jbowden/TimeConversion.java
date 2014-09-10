package jbowden;

import jbowden.Prompt;
import jbowden.Prompter;
import java.util.*;

public class TimeConversion implements Prompt<Integer> {

    private final int MINUTES_PER_HOUR = 60;

    private final Scanner scanner;
    private final Prompter<Integer> prompter;
    
    public static void main(String[] args) {
        new TimeConversion().run();
    }
    
    public TimeConversion() {
       this.scanner = new Scanner(System.in);
       this.prompter = new Prompter<Integer>(this, scanner);
    }
    
    public void run() {
        System.out.println("Minutes -> Hours & Minutes Converter");
        
        final int minutes = prompter.prompt();
        printTime(minutes);
        
        prompter.dispose();
    }
    
    private void printTime(int minutes) {
        final int hours = minutes / MINUTES_PER_HOUR;
        final int minutesLeft = minutes % MINUTES_PER_HOUR;
        
        // TODO: Print out the calculation
        System.out.println("=> ");
    }
    
    @Override
    public void onError(Exception e) {
        System.out.println("Error: Invalid format. Input a number less than 4.5.");
    }
    
    @Override
    public void onPrompt() {
        System.out.print("Enter time in minutes: ");
    }
    
    @Override
    public Integer onInput() {
        return scanner.nextInt();
    }
}