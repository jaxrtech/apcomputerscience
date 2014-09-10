package jbowden.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class RuleReader<R extends Rule> {
    protected final List<String> lines;
    protected final Pattern pattern;

    protected RuleReader(List<String> lines, Pattern pattern) {
        this.lines = lines;
        this.pattern = pattern;
    }

    public List<R> getRules() {
        List<R> rules = new ArrayList<R>();

        for (String line : lines) {
            rules.add(parseRule(line));
        }

        return rules;
    }

    protected abstract R parseRule(String line);

    /**
     * If the `inputText` is equal to the `matchText`, it returns and `matchResult`.
     * Otherwise, `inputText` is parsed as a double.
     *
     * @param inputText  the raw input
     * @param matchText  the text we are trying to match with the `inputText`
     * @param matchResult  the result if the `inputText` equals the `matchText`
     * @return the resulting value, either the `matchResult` or the parsed double.
     */
    protected double tryMatchOrParse(String inputText, String matchText, double matchResult) {
        if (inputText.equals(matchText)) {
            return matchResult;
        } else {
            return Double.parseDouble(inputText);
        }
    }
}
