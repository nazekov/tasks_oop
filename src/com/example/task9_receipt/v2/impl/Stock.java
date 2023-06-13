package com.example.task9_receipt.v2.impl;

import com.example.task9_receipt.v2.IInventory;
import com.example.task9_receipt.v2.IStock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements IStock {

    private List<IInventory> inventoryItemList;

    public Stock() {
        inventoryItemList = new ArrayList<>();
    }

    public Stock(List<IInventory> inventoryItemList) {
        this.inventoryItemList = inventoryItemList;
    }

    @Override
    public List<IInventory> getInventoryItemList() {
        return inventoryItemList;
    }

    public void setInventoryItemList(List<IInventory> inventoryItemList) {
        this.inventoryItemList = inventoryItemList;
    }

    @Override
    public void addInventory(IInventory item) {
        inventoryItemList.add(item);
    }

    @Override
    public Inventory getInventory(int id) {
        return (Inventory) inventoryItemList.stream()
                .filter(inventory -> inventory.getProduct().getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void showAllInfo() {
        System.out.println("\nВсе товары: ");
        inventoryItemList.forEach(IInventory::showInfo);
    }
}
