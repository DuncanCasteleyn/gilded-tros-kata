package com.gildedtros.sell.in;

import com.gildedtros.Item;

public class DefaultSellInModifier implements SellInModifier {
    public static final DefaultSellInModifier SINGLETON = new DefaultSellInModifier();

    private DefaultSellInModifier() {
    }

    @Override public void dayHasPassed(Item item) {
        if (item.sellIn == Integer.MIN_VALUE) {
            return;
        }

        item.sellIn -= 1;
    }
}
