package com.example.task6_printer.v1;

public class Printer implements Printable {

    private int paintVolume;

    public Printer() {
    }

    public Printer(int paintVolume) {
        this.paintVolume = paintVolume;
    }

    @Override
    public int getPaintVolume() {
        return paintVolume;
    }

    @Override
    public void print(String text) {
        int textSize = text.trim().replaceAll("\\s+", "").length();
        if (textSize > paintVolume) {
            System.out.println("Не хватило краски: " + (textSize - paintVolume)
                                            + " (всего краски в принтере " + paintVolume);
        } else {
            System.out.println("На печать отправлен текст: " + text + ", длина: "  + textSize);
            paintVolume -= textSize;
            System.out.println("Текст распечатан: " + text
                                            + ", у принтера осталось краски: " + paintVolume);
        }
    }

    @Override
    public void charge(int volume) {
        paintVolume += volume;
        System.out.println("Принтер пополнен на длину текста " + volume
                        + " (всего краски в принтере: " + paintVolume + ")");
    }
}
