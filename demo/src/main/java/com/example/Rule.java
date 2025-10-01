package com.example;

import java.util.List;

public class Rule {
    private List<Fact> conditions;
    private String conclusion;

    public Rule(List<Fact> conditions, String conclusion) {
        this.conditions = conditions;
        this.conclusion = conclusion;
    }

    public boolean isApplicable(List<Fact> facts) {
        for (Fact condition : conditions) {
            boolean matched = false;
            for (Fact fact : facts) {
                if (fact.getName().equals(condition.getName()) && fact.getValue() == condition.getValue()) {
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return true;
    }

    public String getConclusion() {
        return conclusion;
    }
}
