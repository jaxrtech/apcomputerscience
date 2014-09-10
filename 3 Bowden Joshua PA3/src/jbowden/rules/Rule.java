package jbowden.rules;

/**
 * A rule that is applicable to a set of criteria
 * @param <C>  the type of the criteria
 */
public interface Rule<C> {
    boolean isApplicable(C criteria);
}
