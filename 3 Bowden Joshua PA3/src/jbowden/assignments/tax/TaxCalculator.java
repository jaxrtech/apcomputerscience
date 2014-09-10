package jbowden.assignments.tax;

import jbowden.rules.SingleRuleSelector;

import java.util.Set;

class TaxCalculator {
    private final double salary;
    private final TaxRule rule;

    public TaxCalculator(double salary, Set<TaxRule> rules) {
        this.salary = salary;
        this.rule = new SingleRuleSelector<TaxRule, TaxRuleCriteria>(rules).getRule(new TaxRuleCriteria(salary));
    }

    public double getTaxDue() {
        final double baseTax = rule.getBaseTax();
        final double salaryOverLowerBound = salary - rule.getLowerBound();
        final double extraTax = salaryOverLowerBound * rule.getTaxPercentage();

        return baseTax + extraTax;
    }
}
