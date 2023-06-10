package com.example.task9_receipt;

import java.math.BigDecimal;

public interface IShop {

    BigDecimal getBalance();

    IStock getIStock();

    ICashier getICashier();

    void increaseBalance(BigDecimal money);

    void run();
}
