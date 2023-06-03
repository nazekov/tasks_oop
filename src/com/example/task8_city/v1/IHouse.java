package com.example.task8_city.v1;

import java.util.List;

public interface IHouse {

    String getAddress();

    List<IFlat> getFlatList();

    void addFlat(IFlat flat);

    void showInfo();
}
