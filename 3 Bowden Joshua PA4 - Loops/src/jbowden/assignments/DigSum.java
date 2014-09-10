package jbowden.assignments;

import java.util.*;

/**
 * Class DigSum 
 */

public class DigSum
{
	public static void main(String[] args)
	{	    
	    Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an integer: ");
        final int input = scanner.nextInt();

        int total = 0;
        final String inputString = Integer.toString(input);
        for (char c : inputString.toCharArray()) {
            final String charAsString = new String(new char[]{c});
            total += Integer.parseInt(charAsString);
        }

        System.out.printf("The sum of the digits in %d is %d.\n", input, total);
	}
}
