package com.example.task5_icomp.v1;

public class Monitor implements ITechnic {

    private String name;

    public Monitor(String name) {
        this.name = name;
    }

    @Override
    public void on() {
        System.out.println("используется монитор " + name);
    }

    @Override
    public void off() {
        System.out.println("используется монитор " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
