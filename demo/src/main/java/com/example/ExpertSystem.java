package com.example;

import java.util.*;

public class ExpertSystem {
    // Méthode pour exécuter le système expert
    public String run(Scanner scanner) {
    
        KnowledgeBase kb = new KnowledgeBase();

        // Ajout des règles
        kb.addRule(new Rule(Arrays.asList(new Fact("pc_ne_demarre_pas", true), new Fact("cable_alimentation", false)), "Alimentation débranchée"));
        kb.addRule(new Rule(Arrays.asList(new Fact("pc_ne_demarre_pas", true), new Fact("cable_alimentation", true)), "Alimentation défectueuse"));
        kb.addRule(new Rule(Arrays.asList(new Fact("ecran_noir", true), new Fact("cable_ecran", false)), "Câble écran débranché"));
        kb.addRule(new Rule(Arrays.asList(new Fact("ecran_noir", true), new Fact("cable_ecran", true)), "Carte graphique défectueuse"));
        kb.addRule(new Rule(Arrays.asList(new Fact("aucun_son", true), new Fact("haut_parleurs", false)), "Haut-parleurs débranchés"));
        kb.addRule(new Rule(Arrays.asList(new Fact("aucun_son", true), new Fact("haut_parleurs", true)), "Pilote audio manquant"));
        kb.addRule(new Rule(Arrays.asList(new Fact("pas_internet", true), new Fact("wifi_active", false)), "Wi-Fi désactivé"));
        kb.addRule(new Rule(Arrays.asList(new Fact("pas_internet", true), new Fact("wifi_active", true)), "Problème de routeur"));
        kb.addRule(new Rule(Arrays.asList(new Fact("souris_inactive", true)), "Souris débranchée ou pile vide"));
        kb.addRule(new Rule(Arrays.asList(new Fact("pc_demarre", true), new Fact("aucun_son", true), new Fact("haut_parleurs", true)), "Configuration audio incorrecte"));

        // Interaction utilisateur
        List<Fact> facts = new ArrayList<>();
        facts.add(new Fact("pc_ne_demarre_pas", ask(scanner, "Le PC ne démarre pas ? (o/n)")));
        facts.add(new Fact("ecran_noir", ask(scanner, "L'écran reste noir ? (o/n)")));
        facts.add(new Fact("aucun_son", ask(scanner, "Le PC démarre mais aucun son ? (o/n)")));
        facts.add(new Fact("souris_inactive", ask(scanner, "La souris ne répond pas ? (o/n)")));
        facts.add(new Fact("pas_internet", ask(scanner, "La connexion Internet ne fonctionne pas ? (o/n)")));
        facts.add(new Fact("cable_alimentation", ask(scanner, "Le câble d'alimentation est branché ? (o/n)")));
        facts.add(new Fact("cable_ecran", ask(scanner, "Le câble de l'écran est branché ? (o/n)")));
        facts.add(new Fact("wifi_active", ask(scanner, "Le Wi-Fi est activé ? (o/n)")));
        facts.add(new Fact("haut_parleurs", ask(scanner, "Les haut-parleurs sont branchés ? (o/n)")));
        facts.add(new Fact("pc_demarre", ask(scanner, "Le PC démarre (s'allume) ? (o/n)")));

        // Exécution du moteur d'inférence
        InferenceEngine engine = new InferenceEngine();
        return engine.run(facts, kb);
    }

    // Méthode utilitaire pour poser les questions
    private boolean ask(Scanner sc, String question) {
        System.out.print(question + " ");
        String answer = sc.nextLine().trim().toLowerCase();
        return answer.equals("o") || answer.equals("oui") || answer.equals("y");
    }

}
