package jbowden.assignments.tax;

import jbowden.rules.Rule;

class TaxRule implements Rule<TaxRuleCriteria> {
    private final String name;
    private final double lowerBound;
    private final double upperBound;
    private final double baseTax;
    private final double taxPercentage;

    TaxRule(String name, double lowerBound, double upperBound, double baseTax, double taxPercentage) {
        this.name = name;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.baseTax = baseTax;
        this.taxPercentage = taxPercentage;
    }

    @Override
    public boolean isApplicable(TaxRuleCriteria criteria) {
        final double salary = criteria.getSalary();
        return salary >= lowerBound && salary < upperBound;
    }

    public String getName() {
        return name;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getBaseTax() {
        return baseTax;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    @Override
    public String toString() {
        return "TaxRule{" +
                "name='" + name + '\'' +
                ", lowerBound=" + lowerBound +
                ", upperBound=" + upperBound +
                ", baseTax=" + baseTax +
                ", taxPercentage=" + taxPercentage +
                '}';
    }
}
