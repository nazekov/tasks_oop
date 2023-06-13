package com.example.task9_receipt.v2.impl;

import com.example.task9_receipt.v2.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cashier implements ICashier {

    private String name;

    private IShop shop;

    private IStock stock;

    private Receipt receipt;

    private Scanner sc;

    public Cashier() {
    }

    public Cashier(Shop shop) {
        name = "E1520";
        this.shop = shop;
        this.stock = shop.getIStock();
        sc = new Scanner(System.in);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public IShop getShop() {
        return shop;
    }

    public void setShop(IShop shop) {
        this.shop = shop;
    }

    @Override
    public IStock getShopStock() {
        return stock;
    }

    public void setShopStock(IStock stock) {
        this.stock = stock;
    }

    @Override
    public Receipt createOrder() {
        Util.clearConsole();
        Contact contact = new Contact(
                "SUPERMARKET 123",
                "12, MILKYWAY Galaxy/ Earth",
                "123-456-7890");
        List<Item> itemList = chooseProducts();
        calculateTotalPriceForEveryItem(itemList);

        calculateSpacesForReceipt(itemList);// здесь считаются пробелы

        BigDecimal taxableTotal = getTaxableTotal(itemList);
        BigDecimal vat = getVat(taxableTotal);
        BigDecimal total = taxableTotal.add(vat).setScale(2, BigDecimal.ROUND_HALF_UP);
        Order order = getOrder(itemList, taxableTotal, vat, total);

        shop.increaseBalance(total); // пополняем баланс магазина

        return new Receipt.Builder()
                            .contact(contact)
                            .cashier(this)
                            .date(new Date())
                            .order(order)
                            .build();
    }

    private void calculateSpacesForReceipt(List<Item> itemList) {
        calculateMaxCountLength(itemList);
        calculateMaxDescriptionLength(itemList);
        calculateMaxPriceLength(itemList);
        calculateMaxDiscountLength(itemList);
        calculateMaxTotalLength(itemList);
    }

    private void calculateMaxTotalLength(List<Item> itemList) {
        Item.MAX_TOTAL_LENGTH = itemList.stream()
                .mapToInt(item -> item.getTotal().toString().length() + Item.CURRENCY_SYMBOL.length())
                .max()
                .getAsInt();
        Item.MAX_TOTAL_LENGTH = Math.max(Item.TOTAL_STR.length(), Item.MAX_TOTAL_LENGTH);
    }

    private void calculateMaxDiscountLength(List<Item> itemList) {
        Item.MAX_DISCOUNT_LENGTH = itemList.stream()
                .mapToInt(item -> item.getDiscount().toString().length() + Item.CURRENCY_SYMBOL.length())
                .max()
                .getAsInt();
        Item.MAX_DISCOUNT_LENGTH = Math.max(Item.DISCOUNT_STR.length(), Item.MAX_DISCOUNT_LENGTH);
    }

    private void calculateMaxPriceLength(List<Item> itemList) {
        Item.MAX_PRICE_LENGTH = itemList.stream()
            .mapToInt(item -> item.getProduct().getPrice().toString().length() + Item.CURRENCY_SYMBOL.length())
            .max()
            .getAsInt();
        Item.MAX_PRICE_LENGTH = Math.max(Item.PRICE_STR.length(), Item.MAX_PRICE_LENGTH);
    }

    private void calculateMaxDescriptionLength(List<Item> itemList) {
        Item.MAX_DESCRIPTION_LENGTH = itemList.stream()
                .mapToInt(item -> item.getProduct().getName().length())
                .max()
                .getAsInt();
        Item.MAX_DESCRIPTION_LENGTH = Math.max(Item.DESCRIPTION_STR.length(), Item.MAX_DESCRIPTION_LENGTH);
    }

    private void calculateMaxCountLength(List<Item> itemList) {
        Item.MAX_COUNT_LENGTH = itemList.stream()
                .mapToInt(item -> String.valueOf(item.getCount()).length())
                .max()
                .getAsInt();
        Item.MAX_COUNT_LENGTH = Math.max(Item.QTY_STR.length(), Item.MAX_COUNT_LENGTH);
    }

    private BigDecimal getVat(BigDecimal taxableTotal) {
        BigDecimal unit = IOrder.PERCENT_VAT.divide(new BigDecimal(100));
        return taxableTotal.multiply(unit)
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private Order getOrder(List<Item> itemList,
                           BigDecimal taxableTotal,
                           BigDecimal vat,
                           BigDecimal total) {
        Order order = new Order();
        order.setItemList(itemList);
        order.setTaxableTotal(taxableTotal);
        order.setVat(vat);
        order.setTotal(total);
        return order;
    }

    private BigDecimal getTaxableTotal(List<Item> itemList) {
        BigDecimal taxableTotal = new BigDecimal(0);
        List<BigDecimal> collectTotalList = itemList.stream()
                .map(Item::getTotal)
                .collect(Collectors.toList());
        for (BigDecimal total : collectTotalList) {
            taxableTotal = taxableTotal.add(total);
        }

        System.out.println("Есть ли у вас скидочная карта: 1 - Да / Любая клав. - Нет: ");
        if (sc.nextLine().equals("1")) {
            BigDecimal unit = IOrder.PERCENT_DISCOUNT.divide(new BigDecimal(100));
            unit = new BigDecimal(1).subtract(unit);
            taxableTotal = taxableTotal.multiply(unit);
        }

        return taxableTotal;
    }

    private void calculateTotalPriceForEveryItem(List<Item> itemList) {
        itemList.forEach(
            item -> {
                Product product = item.getProduct();
                BigDecimal price = product.getPrice();
                BigDecimal percentDiscount = product.getPercentDiscount();

                BigDecimal sum = price.multiply(new BigDecimal(item.getCount()));
                BigDecimal discount = new BigDecimal(0);

                if (isDiscount(item.getCount(), percentDiscount)) {
                    BigDecimal unit = percentDiscount.divide(new BigDecimal(100));
                    discount = sum.multiply(unit).setScale(2, BigDecimal.ROUND_HALF_UP);
                }

                BigDecimal totalSum = sum.subtract(discount)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

                item.setDiscount(discount);
                item.setTotal(totalSum);
            }
        );
    }

    private List<Item> chooseProducts() {
        List<Item> itemList = new ArrayList<>();
        boolean isChoose = true;
        while (isChoose) {
            System.out.println("Создание заказа: ");
            stock.showAllInfo();
            System.out.println("Выберите товар");
            System.out.print("Введите номер id товара: ");
            int id = Util.getNumber();
            System.out.print("Введите кол-во желаемых товаров: ");
            int count = Util.getNumber();

            Inventory inventory = stock.getInventory(id);

            if (inventory == null) {
                System.out.println("Такого товара нет в магазине.");
                System.out.println("Продолжить выбор товара дальше? (ENTER - да / 0 - нет)");
                isChoose = isContinueForChoose();
                Util.clearConsole();
                continue;
            }

            if (count > inventory.getCount()) {
                System.out.println("Товара в таком количестве нет. Продолжить ENTER");
                sc.nextLine();
                Util.clearConsole();
                continue;
            }
             // уменьшается число продуктов в хранилище магазина
            inventory.setCount(inventory.getCount() - count);

            Item itemFound = getItem(itemList, id);

            if (itemFound == null) {
                itemList.add(new Item(count, inventory.getProduct()));
            } else {
                itemFound.setCount(itemFound.getCount() + count);
            }

            System.out.println("Продолжить выбор товара дальше? (ENTER - да / 0 - нет)");
            isChoose = isContinueForChoose();
            Util.clearConsole();
        }
        return itemList;
    }

    private Item getItem(List<Item> itemList, int id) {
        return itemList.stream()
                .filter(item -> item.getProduct().getId() == id)
                .findFirst()
                .orElse(null);
    }

    private boolean isDiscount(int count, BigDecimal percentDiscount) {
        return count >= Product.COUNT_FOR_DISCOUNT && containsDiscount(percentDiscount);
    }

    private boolean containsDiscount(BigDecimal percentDiscount) {
        return percentDiscount.compareTo(BigDecimal.valueOf(0)) != 0;
    }

    private boolean isContinueForChoose() {
        return !sc.nextLine().equals("0");
    }

    @Override
    public String toString() {
        return "CASHIER: " + name;
    }
}
