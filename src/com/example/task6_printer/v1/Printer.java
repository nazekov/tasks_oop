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
        String result = null;
        int textSize = text.trim().replaceAll("\\s+", "").length();
        if (textSize > paintVolume) {
//            System.out.println("Не хватило краски: " + (textSize - paintVolume)
//                                            + " (всего краски в принтере " + paintVolume);
            result = String.format("Не хватило краски: %d (всего краски в принтере %d)", textSize - paintVolume, paintVolume);
            System.out.println(result);
        } else {
            result = String.format("На печать отправлен текст: %s, длина: %d", text, textSize);
//            System.out.println("На печать отправлен текст: " + text + ", длина: "  + textSize);
            System.out.println(result);
            paintVolume -= textSize;
            result = String.format("Текст распечатан: %s, у принтера осталось краски: %d", text, paintVolume);
//            System.out.println("Текст распечатан: " + text
//                                            + ", у принтера осталось краски: " + paintVolume);
            System.out.println(result);
        }
    }

    @Override
    public void charge(int volume) {
        paintVolume += volume;
        String result = String.format("Принтер пополнен на длину текста %d (всего краски в принтере: %d)", volume, paintVolume);
//        System.out.println("Принтер пополнен на длину текста " + volume
//                        + " (всего краски в принтере: " + paintVolume + ")");
        System.out.println(result);
    }
}
