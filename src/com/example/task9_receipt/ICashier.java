package com.example.task9_receipt;

import com.example.task9_receipt.impl.Shop;

public interface ICashier {

    String getName();

    Receipt getReceipt();

    IShop getShop();

    IStock getShopStock();

    Receipt createOrder();
}
