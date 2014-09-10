package jbowden.prompting;

public interface Prompt<T>
{   
    /**
     * Called when an error occurs jbowden.prompting the user.
     */
    void onError(Exception e);
    
    /**
     * Called when the prompt message is to be shown to the user.
     */
    void onPrompt();
    
    /**
     * Called when the input for the promt is requested.
     */
    T onInput();
}
