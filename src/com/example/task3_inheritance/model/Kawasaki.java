package com.example.task3_inheritance.model;

public class Kawasaki extends Motorbike {

    private int year;

    public Kawasaki() {
    }

    public Kawasaki(String name,
                    String model,
                    String color,
                    double volume,
                    int year) {
        super(name, model, color, volume);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void jump() {
        System.out.println("Kawasaki jump");
    }
}
