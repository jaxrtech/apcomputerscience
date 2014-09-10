package jbowden.assignments.telephone;

import jbowden.rules.MultiRuleSelector;
import jbowden.prompting.Prompter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TelephoneProgram implements Runnable {

    private static final Prompter prompter = Prompter.getInstance();

    private static final List<AdditiveTelephoneRule> additiveRules;

    static {
        additiveRules = new ArrayList<AdditiveTelephoneRule>();

        // Since the rule applies to times from 6:00 pm (1800 hours) to 8:00 am (0800 hours) which
        // goes into another day, we just put another rule from the start of the next day to the
        // 0800 hours
        additiveRules.add(Rules.generateRule("Rule A: 1800 hrs - 2400 hrs", new Time(18, 0), new Time(24, 0), .50));
        additiveRules.add(Rules.generateRule("Rule A: 0000 hrs - 0800 hrs", new Time(0, 0), new Time(8, 0), .50));

        additiveRules.add(Rules.generateLongCallRule());
        additiveRules.add(Rules.generateTaxRule());
    }

    private final Scanner scanner = new Scanner(System.in);

    public TelephoneProgram() {
    }

    @Override
    public void run() {
        final Time startTime = promptTime("Enter the time the call begins in 24 hour format: ");
        final Time endTime = promptTime("Enter the time the call ends in 24 hour format: ");

        // Create a set of criteria from the input so that we can use it to select the correct rules
        // to use to calculate the cost
        final TelephoneRuleCriteria criteria = new TelephoneRuleCriteria(startTime, endTime);

        final Time duration = startTime.durationTo(endTime);

        final MultiRuleSelector<AdditiveTelephoneRule, TelephoneRuleCriteria> selector =
                new MultiRuleSelector<AdditiveTelephoneRule, TelephoneRuleCriteria>(additiveRules);
        final Queue<AdditiveTelephoneRule> selectedRules = selector.getRules(criteria);

        final CostCalculator calculator = new CostCalculator(Rules.generateBaseRule(), selectedRules, criteria);

        System.out.println("Call summary:");
        System.out.printf("Started at %s for %d minutes\n", startTime.toFormattedString(), duration.asMinutes());
        System.out.printf("The gross cost of the call is $%.2f\n", calculator.getGrossCost());
        System.out.printf("The net cost of the call is $%.2f\n", calculator.getNetCost());
    }

    private Time promptTime(String promptMessage) {
        return prompter.prompt(scanner, new TimePrompt(scanner, promptMessage));
    }
}

