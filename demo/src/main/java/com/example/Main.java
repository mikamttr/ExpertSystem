package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpertSystem system = new ExpertSystem();
        String result = system.run(scanner);
        System.out.println("Diagnostic : " + result);
        scanner.close();
    }
}
