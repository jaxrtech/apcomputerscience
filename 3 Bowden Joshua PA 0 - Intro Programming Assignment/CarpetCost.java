import java.util.*;

public class CarpetCost {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println("What is the width of the room? ");
        final double width = console.nextDouble();
        
        System.out.println("What is the length of the room? ");
        final double length = console.nextDouble();
        
        final double pricePerSqFoot = 2.50;
        final double area = length * width;
        final double cost = area * pricePerSqFoot;
        
        System.out.println("The area of the " + width + " by " + length + " room is " + area);
        System.out.printf("At $%.2f per square ft, the total cost is $%.2f\n", pricePerSqFoot, cost);
        
        console.close();
    }
}