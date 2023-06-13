package com.example.task9_receipt.v2;

import java.util.List;

public interface IStock {

    List<IInventory> getInventoryItemList();

    void addInventory(IInventory item);

    IInventory getInventory(int id);

    void showAllInfo();
}
