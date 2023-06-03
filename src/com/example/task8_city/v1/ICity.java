package com.example.task8_city.v1;

import java.util.List;

public interface ICity {

    String getName();

    List<IHouse> getHouseList();

    void showSettledList();

    void addHouse(IHouse house);
}
