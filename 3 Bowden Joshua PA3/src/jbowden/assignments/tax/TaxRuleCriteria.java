package jbowden.assignments.tax;

class TaxRuleCriteria {
    private final double salary;

    TaxRuleCriteria(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
