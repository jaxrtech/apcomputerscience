package jbowden.assignments;

/**
 * Class Trace1
 *   -- Discuss the process of tracing a program.
 *   -- Demonstrate the use of the BlueJ debugger.
 * 
 */
public class Trace1
{
    public static void main(String[] args)
    {
        int s = 0;
        int i = 1;

        while (i <= 4) 
        {
            s += i; //s=s+i
            i++;
        }

        System.out.println(s);
    }
}
