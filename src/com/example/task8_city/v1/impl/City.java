package com.example.task8_city.v1.impl;

import com.example.task8_city.v1.ICity;
import com.example.task8_city.v1.IHouse;

import java.util.ArrayList;
import java.util.List;

public class City implements ICity {

    private String name;

    private List<IHouse> houseList;

    public City() {
    }

    public City(String name) {
        this.name = name;
        houseList = new ArrayList<>();
    }

    public City(String name, List<IHouse> houseList) {
        this.name = name;
        this.houseList = houseList;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<IHouse> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<IHouse> houseList) {
        this.houseList = houseList;
    }

    @Override
    public void showSettledList() {
        System.out.println("Город: " + name);
        if (houseList.size() == 0) {
            System.out.println("Город пока пуст");
            return;
        }
        houseList.forEach(IHouse::showInfo);
    }

    @Override
    public void addHouse(IHouse house) {
        houseList.add(house);
    }
}
