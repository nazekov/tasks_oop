package com.example.task9_receipt.v1;

public interface ICashier {

    String getName();

    Receipt getReceipt();

    IShop getShop();

    IStock getShopStock();

    Receipt createOrder();
}
