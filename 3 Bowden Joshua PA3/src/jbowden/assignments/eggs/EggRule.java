package jbowden.assignments.eggs;

import jbowden.rules.Rule;

class EggRule implements Rule<EggRuleCriteria> {
    private final double lowerBound;
    private final double upperBound;
    private final double pricePerDozen;

    EggRule(double lowerBound, double upperBound, double pricePerDozen) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public boolean isApplicable(EggRuleCriteria criteria) {
        final int eggCount = criteria.getEggCount() / Util.DOZEN_COUNT;
        return eggCount >= lowerBound && eggCount < upperBound;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }
}
