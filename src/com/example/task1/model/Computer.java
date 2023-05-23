package com.example.task1.model;

public class Computer {

    String name;

    public Computer() {
        this.name = "IBM";
    }

    public Computer(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name +  " on");
    }

    public void off() {
        System.out.println(name +  " off");
    }
}
