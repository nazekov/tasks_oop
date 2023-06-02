package com.example.task5_icomp.v2;

public class Computer implements IComputer {

    private String name;

    private IMonitor monitor;

    public Computer() {
    }

    public Computer(String name, IMonitor monitor) {
        this.name = name;
        this.monitor = monitor;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public IMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(IMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void on() {
        System.out.println("Компьютер включился " + name +
                    ", используется монитор " + monitor.getName());
    }

    @Override
    public void off() {
        System.out.println("Компьютер отключился " + name +
                ", используется монитор " + monitor.getName());
    }
}
