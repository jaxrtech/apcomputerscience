package jbowden.assignments.telephone;

class TelephoneRuleCriteria {
    private final Time start;
    private final Time end;
    private final Time duration;

    public TelephoneRuleCriteria(Time start, Time end) {
        this.start = start;
        this.end = end;
        this.duration = start.durationTo(end);
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public Time getDuration() {
        return duration;
    }
}
