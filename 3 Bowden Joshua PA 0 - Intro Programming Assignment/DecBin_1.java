// Source file

/**
 * DecBin_1: Convert a number between 0 and 15 from decimal to binary.
 * 
 * Day 1:
 *    Topics:
 *      1) Comments // and /* Style
 *      2) print and printf
 *      3) Syntax Errors and Logic Errors
 *      3) What is a variable? Declaring Variables
 *      4) Assignment statements
 */
public class DecBin_1 {

    public static void main(String[] args) {
        run(13, 2);
    }
    
    public static void run(int n, int base) {
        System.out.println("Welcome to the decimal to binary conversion program!");
        System.out.println("(" + n + ")_10 -> (?)_2 = " + convert(n, base));
    }
    
    private static String convert(int n, int base) {
        return convertRaw(base, n, "", true);
    }
    
    private static String convertRaw(int divisor, int quotient, String result, boolean isFirst) {
        if (quotient == 0) { 
            return result;
        } else {
            int quotientPrime = quotient / divisor;
            int remainder = quotient % divisor;
            String comma = (divisor > 9 && !isFirst) ? "," : "";
            return convertRaw(divisor, quotientPrime, remainder + comma + result, false);
        }
    }
}
