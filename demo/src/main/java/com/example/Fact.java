package com.example;

public class Fact {
    private String name;
    private boolean value;

    public Fact(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public boolean getValue() { return value; }

    @Override
    public String toString() {
        return name + " = " + value;
    }
}
