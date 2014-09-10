package jbowden.rules;

import java.util.Set;

/**
 * Selects the first applicable rule from a list of rules using criteria.
 * @param <R>  the type of the rule
 * @param <C>  the type of the criteria to match for the rule
 */
public class SingleRuleSelector<R extends Rule<C>, C> {
    private final Set<R> rules;

    public SingleRuleSelector(Set<R> rules) {
        this.rules = rules;
    }

    public R getRule(C criteria) {
        for (R rule : rules) {
            if (rule.isApplicable(criteria)) {
                return rule;
            }
        }

        throw new IllegalStateException("Unable to find applicable rule.");
    }
}
