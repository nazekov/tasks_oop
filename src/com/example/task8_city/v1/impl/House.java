package com.example.task8_city.v1.impl;

import com.example.task8_city.v1.IFlat;
import com.example.task8_city.v1.IHouse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House implements IHouse {

    private String address;

    private List<IFlat> flatList;

    public House() {
    }

    public House(String address) {
        this.address = address;
        flatList = new ArrayList<>();
    }

    public House(String address, List<IFlat> flatList) {
        this.address = address;
        this.flatList = flatList;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public List<IFlat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<IFlat> flatList) {
        this.flatList = flatList;
    }

    @Override
    public void addFlat(IFlat flat) {
        flatList.add(flat);
    }

    @Override
    public void showInfo() {
        System.out.println("\nДом: " + address);
        flatList.forEach(IFlat::showInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
