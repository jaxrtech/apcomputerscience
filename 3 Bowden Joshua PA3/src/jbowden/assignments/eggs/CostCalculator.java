package jbowden.assignments.eggs;

import jbowden.rules.SingleRuleSelector;

import java.util.Set;

class CostCalculator {
    private final Set<EggRule> rules;

    public CostCalculator(Set<EggRule> rules) {
        this.rules = rules;
    }

    public double getTotalCost(int eggsCount) {
        final EggRule rule = new SingleRuleSelector<EggRule, EggRuleCriteria>(rules).getRule(new EggRuleCriteria(eggsCount));

        final double costFromDozens = (eggsCount / Util.DOZEN_COUNT) * rule.getPricePerDozen();
        final double costFromExtra = (eggsCount % Util.DOZEN_COUNT) * (1.0 / (double) Util.DOZEN_COUNT) * rule.getPricePerDozen();

        return costFromDozens + costFromExtra;
    }
}
