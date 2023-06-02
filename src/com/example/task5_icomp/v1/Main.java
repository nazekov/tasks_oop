package com.example.task5_icomp.v1;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Samsung");
        Computer computer = new Computer("MackBook", monitor);
        computer.on();
        computer.off();
    }
}
