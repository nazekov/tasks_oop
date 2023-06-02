package com.example.task5_icomp.v2;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("MacBook", new Monitor("Samsung"));
        computer.on();
        computer.off();
    }
}
