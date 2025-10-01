package com.example;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase {
    private List<Rule> rules = new ArrayList<>();

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return rules;
    }
}
