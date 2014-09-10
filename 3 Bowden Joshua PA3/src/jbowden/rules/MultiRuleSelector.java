package jbowden.rules;

import java.util.*;

/**
 * Selects the all the applicable rules from a list of rules using criteria.
 * @param <R>  the type of the rules
 * @param <C>  the type of the criteria to match for the rules
 */
public class MultiRuleSelector<R extends Rule<C>, C> {
    private final List<R> rules;

    public MultiRuleSelector(List<R> rules) {
        this.rules = rules;
    }

    public Queue<R> getRules(C criteria) {
        Queue<R> pickedRules = new LinkedList<R>();

        for (R rule : rules) {
            if (rule.isApplicable(criteria)) {
                pickedRules.add(rule);
            }
        }

        return pickedRules;
    }
}
