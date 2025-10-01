package com.example;

import java.util.List;

public class InferenceEngine {

    public String run(List<Fact> facts, KnowledgeBase kb) {
        for (Rule rule : kb.getRules()) {
            if (rule.isApplicable(facts)) {
                return rule.getConclusion();
            }
        }
        return "Aucun diagnostic trouvé.";
    }
}
