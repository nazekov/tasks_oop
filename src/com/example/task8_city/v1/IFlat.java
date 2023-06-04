package com.example.task8_city.v1;

import java.util.List;

public interface IFlat {

    int DEFAULT_CAPACITY = 2;

    int getNumber();

    List<Settler> getSettlerList();

    void addSettler(Settler settler);

    void showInfo();
}
