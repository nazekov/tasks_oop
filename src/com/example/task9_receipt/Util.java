package com.example.task9_receipt;

import java.io.IOException;
import java.util.Scanner;

public class Util {

    private static final Scanner sc = new Scanner(System.in);

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static int getNumber() {
        boolean isNotNumber = true;
        int result = 0;
        while (isNotNumber) {
            try {
                result = Integer.parseInt(sc.nextLine());
                isNotNumber = false;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
        return result;
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCalcSpaceToMaxElem(int maxSpace, String fromElem) {
        stringBuilder.setLength(0);
        int calcSpace = maxSpace - fromElem.length();
        while (calcSpace-- > 0) {
            stringBuilder.append(" ");
        }
//        stringBuilder.append("  ");
        return stringBuilder.toString();
    }

    public static String getCalcSpace(int count, String space) {
        stringBuilder.setLength(0);
        while (count-- > 0) {
            stringBuilder.append(space);
        }
        return stringBuilder.toString();
    }
}
