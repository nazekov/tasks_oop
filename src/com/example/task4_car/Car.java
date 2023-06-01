package com.example.task4_car;

public class Car implements Moveable {

    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        System.out.println(name + " drive");
    }

    @Override
    public void stop() {
        System.out.println(name + " stop");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
