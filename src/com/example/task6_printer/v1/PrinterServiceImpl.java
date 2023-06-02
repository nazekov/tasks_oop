package com.example.task6_printer.v1;

import java.io.IOException;
import java.util.Scanner;

public class PrinterServiceImpl implements PrinterService {

    private Printable printable;

    private boolean isWork;

    public PrinterServiceImpl() {
        isWork = true;
    }

    public PrinterServiceImpl(Printable printable) {
        this.printable = printable;
        isWork = true;
    }

    @Override
    public Printable getPrintable() {
        return printable;
    }

    public void setPrintable(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (isWork) {
            System.out.println("Menu:\n" +
                    "1 - печатать текст \n" +
                    "2 - заполнить принтер \n" +
                    "3 - выйти\n" +
                    "Введите команду: ");
            int cmd = Integer.parseInt(sc.nextLine());
            if (cmd < 1 || cmd > 3) {
                clearConsole();
                System.out.println("Такой команды нет");
                continue;
            }

            if (cmd == 1) {
                System.out.println("Введите текст: ");
                String inputText = sc.nextLine();
                printable.print(inputText);
            } else if (cmd == 2) {
                System.out.println("На какую величину вы желаете заполнить: ");
                int inputVolume = Integer.parseInt(sc.nextLine());
                printable.charge(inputVolume);
            } else {
                System.out.println("Конец работы програмы");
                isWork = false;
            }
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
