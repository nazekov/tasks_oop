package com.example.task9_receipt.v1;

import com.example.task9_receipt.v1.impl.Inventory;
import java.util.List;

public interface IStock {

    List<IInventory> getInventoryItemList();

    void addInventory(IInventory item);

    Inventory getInventory(int id);

    void showAllInfo();
}
