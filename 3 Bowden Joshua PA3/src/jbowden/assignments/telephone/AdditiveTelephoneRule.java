package jbowden.assignments.telephone;

import jbowden.rules.Rule;

abstract class AdditiveTelephoneRule implements Rule<TelephoneRuleCriteria> {
    public abstract double getCost(TelephoneRuleCriteria criteria, double currentCost);

    public abstract String getName();

    @Override
    public String toString() {
        return "Rule{'" + getName() + "'}";
    }
}

