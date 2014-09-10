package jbowden.assignments;
/**
 * Class Series1 
 * 
 */
import java.util.*;

public class Series1
{
	public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        
        
        // series s1:  1+(1/2)+(1/4)+...
        System.out.print("Series S1: ");
        
        {
            final int initial = 1;
            final int end = 10;
            int i = 0;
            double total = 0;

            while (i < end) {
                total += Math.pow(1.0 / 2.0, i);
            }

            System.out.println(total);
        }
        
        // series s2:
        //
        System.out.print("Series S2: ");
       
        {
            int total = 0;
            for (int i = 1; i <= 20; i++) {
                total += 3 + 2 * i;
            }

            System.out.println(total);
        }
   
    }
}
