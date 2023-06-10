package com.example.task9_receipt.impl;

import com.example.task9_receipt.IInventory;
import com.example.task9_receipt.Product;
import com.example.task9_receipt.Util;

public class Inventory implements IInventory {

    private Product product;

    private int count;

    private StringBuilder stringBuilder;

    public static int maxSpace;

    public Inventory() {
    }

    public Inventory(Product product, int count) {
        this.product = product;
        this.count = count;
        stringBuilder = new StringBuilder();
    }

    @Override
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void showInfo() {
        System.out.println(product
                + Util.getCalcSpaceToMaxElem(maxSpace, product.getPercentDiscount().toString())
                + "Количество: " + count);
    }
}
