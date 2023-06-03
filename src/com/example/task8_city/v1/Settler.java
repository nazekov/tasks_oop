package com.example.task8_city.v1;

public class Settler {

    private String name;

    public Settler() {
    }

    public Settler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "-- Житель " + name;
    }
}
