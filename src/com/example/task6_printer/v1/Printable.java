package com.example.task6_printer.v1;

public interface Printable {

    int getPaintVolume();

    void print(String text);

    void charge(int volume);
}
