package com.gildedtros.sell.in;

import com.gildedtros.Item;

public interface SellInModifier {
    SellInModifier DEFAULT = DefaultSellInModifier.SINGLETON;

    void dayHasPassed(Item item);
}
