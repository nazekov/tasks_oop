package com.example.task9_receipt.v2.impl;

import com.example.task9_receipt.v2.IInventory;
import com.example.task9_receipt.v2.Product;
import com.example.task9_receipt.v2.Util;

public class Inventory implements IInventory {

    private Product product;

    private int count;

    public static int maxSpace;

    public Inventory() {
    }

    public Inventory(Product product, int count) {
        this.product = product;
        this.count = count;
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
