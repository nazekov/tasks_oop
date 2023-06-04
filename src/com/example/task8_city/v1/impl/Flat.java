package com.example.task8_city.v1.impl;

import com.example.task8_city.v1.IFlat;
import com.example.task8_city.v1.Settler;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements IFlat {

    private int number;

    private List<Settler> settlerList;

    public Flat() {
    }

    public Flat(int number) {
        this.number = number;
        settlerList = new ArrayList<>();
    }

    public Flat(int number, List<Settler> settlerList) {
        this.number = number;
        this.settlerList = settlerList;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public List<Settler> getSettlerList() {
        return settlerList;
    }

    public void setSettlerList(List<Settler> settlerList) {
        this.settlerList = settlerList;
    }

    @Override
    public void addSettler(Settler settler) {
        settlerList.add(settler);
    }

    @Override
    public void showInfo() {
        System.out.println("- Квартира: " + number);
        if (settlerList.size() == 0) {
            System.out.println("квартира пуста.");
            return;
        }
        settlerList.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
