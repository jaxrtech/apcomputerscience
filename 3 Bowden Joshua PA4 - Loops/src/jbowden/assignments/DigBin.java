package jbowden.assignments;

import java.util.*;

/**
 * Class DigBin
 */

public class DigBin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        final int input = scanner.nextInt();

        {
            String binary = decimalToBinaryString(input);
            System.out.printf("(using strings) The sum of the digits in %d is %s.\n", input, binary);
        }

        {
            int binary = decimalToBinaryUsingMath(input);
            System.out.printf("(using math)    The sum of the digits in %d is %d.\n", input, binary);
        }
    }

    private static String decimalToBinaryString(final int input) {
        final int BINARY_BASE = 2;

        String binary = "";
        int carry = input;

        // Keep extracting a digit until the carry is the result in base 2
        while (carry > 0) {
            final int digit = carry % BINARY_BASE;
            carry = carry / BINARY_BASE;
            binary = Integer.toString(digit) + binary;
        }

        return binary;
    }

    private static int decimalToBinaryUsingMath(final int input) {
        final int BINARY_BASE = 2;

        int binary = 0;
        int scale = 1;
        int carry = input;

        // Keep extracting a digit until the carry is the result in base 2
        while (carry > 0) {
            final int digit = carry % BINARY_BASE;
            carry = carry / BINARY_BASE;
            binary += digit * scale;
            scale *= 10;
        }

        return binary;
    }
}
