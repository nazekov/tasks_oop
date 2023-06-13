package com.example.task9_receipt.v2.impl;

import com.example.task9_receipt.v2.IOrder;
import com.example.task9_receipt.v2.Item;
import com.example.task9_receipt.v2.Receipt;
import com.example.task9_receipt.v2.Util;

import java.math.BigDecimal;
import java.util.List;

public class Order implements IOrder {

    private List<Item> itemList;

    private BigDecimal taxableTotal;

    private BigDecimal totalDiscount;

    private BigDecimal vat;

    private BigDecimal total;

    public Order() {
    }

    public Order(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public BigDecimal getTaxableTotal() {
        return taxableTotal;
    }

    public void setTaxableTotal(BigDecimal taxableTotal) {
        this.taxableTotal = taxableTotal;
    }

    @Override
    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public void addItem(Item item) {
        itemList.add(item);
    }

    @Override
    public void showInfo() {
        String left = String.format("%s%s%s%s%s%s%s",
                                    Receipt.BORDER_LINE,
                                    Receipt.BORDER_BLANK,
                                    Item.QTY_STR,
                                    Util.getCalcSpaceToMaxElem(Item.MAX_COUNT_LENGTH, Item.QTY_STR),
                                    Item.BETWEEN_BLANK,
                                    Item.DESCRIPTION_STR,
                                    Util.getCalcSpaceToMaxElem(Item.MAX_DESCRIPTION_LENGTH, Item.DESCRIPTION_STR)
                                    );

        String right = String.format("%s%s%s%s%s%s%s%s%s%s",
                                    Util.getCalcSpaceToMaxElem(Item.MAX_PRICE_LENGTH, Item.PRICE_STR),
                                    Item.PRICE_STR,
                                    Item.BETWEEN_BLANK,
                                    Util.getCalcSpaceToMaxElem(Item.MAX_DISCOUNT_LENGTH, Item.DISCOUNT_STR),
                                    Item.DISCOUNT_STR,
                                    Item.BETWEEN_BLANK,
                                    Util.getCalcSpaceToMaxElem(Item.MAX_TOTAL_LENGTH, Item.TOTAL_STR),
                                    Item.TOTAL_STR,
                                    Receipt.BORDER_BLANK,
                                    Receipt.BORDER_LINE
                                    );

        String middleSpace = Util.getCalcSpace(Receipt.WIDTH - left.length() - right.length(), " ");

        String headTable = String.format("%s%s%s", left, middleSpace, right);

        String viewEmptySpace = Receipt.getViewEmptySpace();

        System.out.println(viewEmptySpace + "\n"
                            + headTable + "\n"
                            + viewEmptySpace);
        itemList.forEach(item -> item.showInfo(middleSpace));

        String totalStr = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s",
            viewEmptySpace,
            Receipt.getViewOneLine("="),
            viewEmptySpace,
            Receipt.getViewStrTwoPosition("TAXABLE TOT.", Item.CURRENCY_SYMBOL + taxableTotal.toString()),
            Receipt.getViewStrTwoPosition("VAT17%", Item.CURRENCY_SYMBOL + vat.toString()),
            Receipt.getViewStrTwoPosition("TOTAL", Item.CURRENCY_SYMBOL + total.toString()),
            viewEmptySpace
        );

        System.out.println(totalStr + "\n" + Receipt.getViewTopDown());
    }
}
