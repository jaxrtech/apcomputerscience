package jbowden.assignments.telephone;

import java.util.Queue;

class CostCalculator {
    private final BaseTelephoneRule baseRule;
    private final Queue<AdditiveTelephoneRule> additiveRules;
    private final TelephoneRuleCriteria criteria;

    /**
     * Creates a new CostCalculator
     * @param baseRule  the base rule used to calculate the base cost
     * @param additiveRules  the selected rules that will be applied in order to the base cost
     * @param criteria  the criteria of the call
     */
    public CostCalculator(BaseTelephoneRule baseRule, Queue<AdditiveTelephoneRule> additiveRules,
                          TelephoneRuleCriteria criteria) {
        this.baseRule = baseRule;
        this.additiveRules = additiveRules;
        this.criteria = criteria;
    }

    /**
     * Returns the cost of the call before any deductions or tax is added.
     */
    public double getGrossCost() {
        return baseRule.getCost(criteria);
    }

    /**
     * Returns the cost te the call with any duductions or tax added.
     */
    public double getNetCost() {
        return applyAdditiveRulesToBaseCost(additiveRules, getGrossCost());
    }

    private double applyAdditiveRulesToBaseCost(Queue<AdditiveTelephoneRule> rules, double currentCost) {
        if (rules.isEmpty()) {
            return currentCost;
        }

        final double newCost = rules.remove().getCost(criteria, currentCost);
        return applyAdditiveRulesToBaseCost(rules, newCost);
    }
}
