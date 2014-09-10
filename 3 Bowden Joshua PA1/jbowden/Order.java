package jbowden;

import java.util.*;

public class Order {
    private final Scanner scanner;
    private final List<OrderEntry> orders;
    
    public static void main(String[] args) {
        new Order().run();
    }
    
    public Order() {
       this.scanner = new Scanner(System.in);
       this.orders = new ArrayList<OrderEntry>();
    }
    
    public void run() {
        System.out.println("Restaurant Order System");
        
        int count;

        System.out.print("Number of burgers: ");
        count = scanner.nextInt();
        orders.add(new BurgerEntry(count));
        
        System.out.print("Number of orders of fries: ");
        count = scanner.nextInt();
        orders.add(new FriesEntry(count));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      new FriesEntry(count);
        
        System.out.print("Number of sodas: ");
        count = scanner.nextInt();
        orders.add(new SodaEntry(count));
        
        SalesSystem system = new SalesSystem(orders);
        System.out.printf("Sub Total    $ %3.2f\n", system.getOrdersTotal());
        System.out.printf("Tax (%.2f%%)  $ %3.2f\n", system.getTaxRate() * 100.0, system.getTaxTotal());
        System.out.printf("Total        $ %3.2f\n\n", system.getTotal());

        System.out.print("Tendered      $");
        final double tendered = scanner.nextDouble();
        final double change = tendered - system.getTotal();

        System.out.printf("Change       $ %3.2f\n\n", change);

        scanner.close();
    }
}

abstract class OrderEntry {
    private int count;

    public OrderEntry(int count) {
        this.count = count;
    }

    public abstract double getPrice();

    public int getCount() {
        return count;
    }

    public double getCost() {
        return count * getPrice();
    }
}

class BurgerEntry extends OrderEntry {
    private final double PRICE = 1.69;

    public BurgerEntry(int count) {
        super(count);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}

class FriesEntry extends OrderEntry {
    private final double PRICE = 1.09;

    public FriesEntry(int count) {
        super(count);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}

class SodaEntry extends OrderEntry {
    private final double PRICE = 0.99;

    public SodaEntry(int count) {
        super(count);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}

class SalesSystem {
    private List<OrderEntry> orders;
    private final double TAX_RATE = 0.065;

    public SalesSystem(List<OrderEntry> orders) {
        this.orders = orders;
    }

    public double getTaxRate() {
        return TAX_RATE;
    }

    public double getOrdersTotal() {
        double total = 0.0;

        for (OrderEntry order : orders) {
            total += order.getCost();
        }

        return total;
    }

    public double getTaxTotal() {
        double total = 0.0;

        for (OrderEntry order : orders) {
            total += order.getCost() * TAX_RATE;
        }

        return total;
    }

    public double getTotal() {
        return getOrdersTotal() + getTaxTotal();
    }
}