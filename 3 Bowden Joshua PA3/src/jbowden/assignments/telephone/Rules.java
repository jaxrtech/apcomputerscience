package jbowden.assignments.telephone;

class Rules {

    public static final double PRICE_PER_MINUTE = 0.40;
    public static final double TAX_RATE = 0.04;
    public static final double LONG_CALL_DISCOUNT_RATE = .15;

    public static AdditiveTelephoneRule generateRule(final String name, final Time startTime, final Time endTime, final double discount) {
        return new AdditiveTelephoneRule() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public double getCost(TelephoneRuleCriteria criteria, double currentCost) {
                return currentCost - (currentCost * discount);
            }

            @Override
            public boolean isApplicable(TelephoneRuleCriteria criteria) {
                return criteria.getStart().isBetweenExclusively(startTime, endTime);
            }
        };
    }

    public static BaseTelephoneRule generateBaseRule() {
        return new BaseTelephoneRule() {
            @Override
            public double getCost(TelephoneRuleCriteria criteria) {
                return criteria.getDuration().asMinutes() * PRICE_PER_MINUTE;
            }

            @Override
            public boolean isApplicable(TelephoneRuleCriteria criteria) {
                return true;
            }
        };
    }

    public static AdditiveTelephoneRule generateTaxRule() {
        return new AdditiveTelephoneRule() {
            @Override
            public String getName() {
                return "Tax";
            }

            @Override
            public double getCost(TelephoneRuleCriteria criteria, double currentCost) {
                return currentCost + currentCost * TAX_RATE;
            }

            @Override
            public boolean isApplicable(TelephoneRuleCriteria criteria) {
                return true;
            }
        };
    }

    public static AdditiveTelephoneRule generateLongCallRule() {
        return new AdditiveTelephoneRule() {
            @Override
            public String getName() {
                return "Long Call Discount";
            }

            @Override
            public double getCost(TelephoneRuleCriteria criteria, double currentCost) {
                return currentCost - (currentCost * LONG_CALL_DISCOUNT_RATE);
            }

            @Override
            public boolean isApplicable(TelephoneRuleCriteria criteria) {
                return criteria.getDuration().asMinutes() > 60;
            }
        };
    }
}
