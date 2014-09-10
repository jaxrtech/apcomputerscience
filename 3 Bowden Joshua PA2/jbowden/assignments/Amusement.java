package jbowden.assignments;

import jbowden.support.DayOfWeekCalculator;
import jbowden.support.WeekDay;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class Amusement {

    public static void main(String[] args) {
        new Amusement().run();
    }

    private static final double TAX_RATE = 0.07;

    private final Scanner scanner;

    private List<Rule> rules = new ArrayList<Rule>();

    {
        Rule tuesdaySpecial = new Rule() {
            @Override
            public EnumSet<WeekDay> getApplicableDays() {
                return EnumSet.of(WeekDay.TUESDAY);
            }

            @Override
            public double getCost(TicketType type) {
                switch (type) {
                    case ADULT: return 10.95;
                    case CHILD: return 6.95;
                    default: throw new IllegalStateException("Invalid ticket type.");
                }
            }
        };
        rules.add(tuesdaySpecial);

        Rule weekdayExceptTuesday = new Rule() {
            @Override
            public EnumSet<WeekDay> getApplicableDays() {
                return EnumSet.of(WeekDay.MONDAY, WeekDay.WEDNESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY);
            }

            @Override
            public double getCost(TicketType type) {
                switch (type) {
                    case ADULT: return 15.95;
                    case CHILD: return 8.95;
                    default: throw new IllegalStateException("Invalid ticket type.");
                }
            }
        };
        rules.add(weekdayExceptTuesday);

        Rule weekends = new Rule() {
            @Override
            public EnumSet<WeekDay> getApplicableDays() {
                return EnumSet.of(WeekDay.SATURDAY, WeekDay.SUNDAY);
            }

            @Override
            public double getCost(TicketType type) {
                switch (type) {
                    case ADULT: return 25.95;
                    case CHILD: return 15.95;
                    default: throw new IllegalStateException("Invalid ticket type.");
                }
            }
        };
        rules.add(weekends);
    }

    public Amusement() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter the date you are planning to visit the park: ");

        System.out.print("Enter the day: ");
        final int day = scanner.nextInt();

        System.out.print("Enter the month (1-12): ");
        final int month = scanner.nextInt();

        System.out.print("Enter the year (4 digits): ");
        final int year = scanner.nextInt();

        System.out.print("How many ADULT tickets are you purchasing? ");
        final int adultTickets = scanner.nextInt();

        System.out.print("How many CHILD tickets are you purchasing? ");
        final int childTickets = scanner.nextInt();

        final WeekDay weekDay = new DayOfWeekCalculator(day, month, year).getWeekDay();
        System.out.printf("\nYou will be visiting the park on %s\n", weekDay.toString());

        final double adultCost = getCost(weekDay, TicketType.ADULT) * adultTickets;
        final double childCost = getCost(weekDay, TicketType.CHILD) * childTickets;
        final double subTotal = adultCost + childCost;
        System.out.printf("The pre-tax cost of %d adult and %d child tickets is $%.2f\n", adultTickets, childTickets, subTotal);

        final double total = subTotal + (subTotal * TAX_RATE);
        System.out.printf("Total Cost (including tax) = $%.2f\n", total);
    }

    private double getCost(WeekDay day, TicketType ticketType) {
        for (Rule rule : rules) {
            if (rule.getApplicableDays().contains(day)) {
                return rule.getCost(ticketType);
            }
        }

        throw new IllegalStateException("Unable to find applicable rule to calculate cost of ticket.");
    }
}

interface Rule {
    EnumSet<WeekDay> getApplicableDays();
    double getCost(TicketType type);
}

enum TicketType {
    ADULT, CHILD
}
