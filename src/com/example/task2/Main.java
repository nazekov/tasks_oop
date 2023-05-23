package com.example.task2;

import com.example.task2.model.Computer;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setName("IBM");
        computer.on();
        computer.off();
    }
}
