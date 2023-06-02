package com.example.task5_icomp.v1;

public class Computer implements ITechnic {

    private String name;
    private Monitor monitor;

    public Computer() {
    }

    public Computer(String name, Monitor monitor) {
        this.name = name;
        this.monitor = monitor;
    }

    @Override
    public void on() {
        System.out.print("Компьютер включился " + name + ", ");
        monitor.on();
    }

    @Override
    public void off() {
        System.out.print("Компьютер отключился " + name + ", ");
        monitor.off();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
