package jbowden.assignments;
/**
 * Class WhileDemo
 * 
 */
import java.util.*;

public class WhileDemo
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Part 1: Multiples of 5 between 0 and 100\n");

        {
            int n = 0;

            while (n < 100) {
                System.out.printf("  %d", n);
            }
        }

        System.out.print("Part 2: Sum of first 100 integers\n");

        {
            final int increment = 5;
            int n = 0;
            int total = 0;

            while (n < 100) {
                n += increment;
                total += n;
            }

            System.out.printf("Sum = %d", total);
        }
        
        System.out.print("Part 3: sequence 2, 5, 8, 11, .. 17\n");
        
        {
            final int start = 2;
            final int increment = 3;
            final int end = 17;
            int value = 0;

            while (value < end) {
                value += increment;
                System.out.printf(" %d ", value);
            }
        }
    }
}
