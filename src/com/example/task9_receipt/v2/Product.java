package com.example.task9_receipt.v2;

import java.math.BigDecimal;

public class Product {

    private int id;

    private String name;

    private BigDecimal price;

    public static int COUNT_FOR_DISCOUNT = 5;

    public static int maxSpace2;

    public static int maxSpace3;

    private StringBuilder stringBuilder;

    private BigDecimal percentDiscount;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price, BigDecimal percentDiscount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.percentDiscount = percentDiscount;
        stringBuilder = new StringBuilder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(BigDecimal percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", "
                + "Товар: " + name + ","
                + Util.getCalcSpaceToMaxElem(maxSpace2, name) + " "
                + "Цена: " + price + ", "
                + Util.getCalcSpaceToMaxElem(maxSpace3, price.toString()) + " "
                + "Скидка в %: " + percentDiscount + " ";
    }
}
