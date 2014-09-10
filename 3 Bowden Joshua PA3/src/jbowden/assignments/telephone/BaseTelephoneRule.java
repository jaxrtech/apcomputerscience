package jbowden.assignments.telephone;

import jbowden.rules.Rule;

interface BaseTelephoneRule extends Rule<TelephoneRuleCriteria> {
    double getCost(TelephoneRuleCriteria criteria);
}
