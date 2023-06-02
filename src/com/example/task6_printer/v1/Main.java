package com.example.task6_printer.v1;

public class Main {

    public static void main(String[] args) {
        PrinterService printerService = new PrinterServiceImpl(new Printer(20));
        printerService.run();
    }
}
