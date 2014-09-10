package jbowden;

import jbowden.Prompt;
import jbowden.Prompter;
import java.util.*;

public class DivAndMod implements Prompt<List<Integer>> {

    private final int NUM_OF_PICKS = 2;

    private final Scanner scanner;
    private final Prompter<List<Integer>> prompter;
    
    public static void main(String[] args) {
        new DivAndMod().run();
    }
    
    public DivAndMod() {
       this.scanner = new Scanner(System.in);
       this.prompter = new Prompter<List<Integer>>(this, scanner);
    }
    
    public void run() {
        System.out.println("DivMod Program");
        
        final List<Integer> numbers = prompter.prompt();
        final int val1 = numbers.get(0);
        final int val2 = numbers.get(1);
        
        System.out.printf("%d / %d = %d\n", val1, val2, val1 / val2);
        System.out.printf("%d / %d = %d\n", val2, val1, val2 / val1);
        
        System.out.printf("%d %% %d = %d\n", val1, val2, val1 % val2);
        System.out.printf("%d %% %d = %d\n", val2, val1, val2 % val1);
        
        prompter.dispose();
    }
    
    @Override
    public void onError(Exception e) {
        System.out.println("Error: Invalid format. Input only integers.");
    }
    
    @Override
    public void onPrompt() {
        System.out.println("Input two numbers:");
    }
    
    @Override
    public List<Integer> onInput() {
        List<Integer> array = new ArrayList<Integer>();
        
        for (int i = 0; i < NUM_OF_PICKS; i++) {
            System.out.print("> ");
            array.add(scanner.nextInt());
        }
        
        return array;
    }
}