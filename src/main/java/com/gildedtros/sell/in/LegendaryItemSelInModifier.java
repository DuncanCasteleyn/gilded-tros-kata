package com.gildedtros.sell.in;

import com.gildedtros.Item;

public class LegendaryItemSelInModifier implements SellInModifier {


    public static final SellInModifier SINGLETON = new LegendaryItemSelInModifier();

    private LegendaryItemSelInModifier() {
    }

    @Override
    public void dayHasPassed(Item item) {
        // Does not have to be sold
    }
}
