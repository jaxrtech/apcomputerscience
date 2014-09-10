package jbowden;

import jbowden.Prompt;
import jbowden.Prompter;
import java.util.*;

public class TempConv implements Prompt<Double> {

    private final Scanner scanner;
    private final Prompter<Double> prompter;
    
    public static void main(String[] args) {
        new TempConv().run();
    }
    
    public TempConv() {
       this.scanner = new Scanner(System.in);
       this.prompter = new Prompter<Double>(this, scanner);
    }
    
    public void run() {
        System.out.println("C° -> F° Converter");
        final double degC = prompter.prompt();
        
        // Formula translated from: F = (9/5) * C + 32
        final double degF = (9.0 / 5.0) * degC + 32.0;
        
        System.out.printf("%.2f C° -> %.2f F°\n", degC, degF);
        
        prompter.dispose();
    }
    
    @Override
    public void onError(Exception e) {
        System.out.println("Error: Invalid format. Input a decimal number.");
    }
    
    @Override
    public void onPrompt() {
        System.out.print("Enter C°: ");
    }
    
    @Override
    public Double onInput() {
        // Input the temperature degrees
        return scanner.nextDouble();
    }
}