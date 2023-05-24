package com.example.task3_inheritance;

import com.example.task3_inheritance.model.Kawasaki;
import com.example.task3_inheritance.model.Ural;

public class Main {
    public static void main(String[] args) {

        Kawasaki kawasaki = new Kawasaki("kawa", "model", "black", 5.5, 2000);
        kawasaki.jump();

        System.out.println();

        Ural ural = new Ural("ural", "model1", "green", 5.7, true);
        ural.showInfo();
    }
}
