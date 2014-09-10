package jbowden.assignments;

/**
 * Class IsPrime
 * 
 * A program to determine whether a given number is prime or not
 */
import java.util.*;

public class IsPrime
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        
        System.out.print("Enter a postive integer value? ");
        final int n = console.nextInt();
        
        // Determine whether the number is prime and display prime or not prime.
        if (isPrime(n)) {
            System.out.println("The number is prime.");
        } else {
            System.out.println("The number is not prime.");
        }
    }

    private static boolean isPrime(int n) {
        for (int divisor = 1; divisor < n; divisor++) {
            if (n % divisor == 0) return false;
        }
        return true;
    }
}