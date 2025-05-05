package com.gildedtros.handler;

import com.gildedtros.Item;
import com.gildedtros.quaility.DefaultQualityModifier;
import com.gildedtros.quaility.QualityModifier;
import com.gildedtros.sell.in.DefaultSellInModifier;
import com.gildedtros.sell.in.SellInModifier;

public class DefaultItemHandler implements ItemHandler {
    public static final DefaultItemHandler SINGLETON = new DefaultItemHandler();

    private final QualityModifier defaultQualityModifier = DefaultQualityModifier.SINGLETON;
    private final SellInModifier defaultSellInModifier = DefaultSellInModifier.SINGLETON;

    @Override public boolean handles(Item item) {
        return true;
    }

    @Override public void updateItemForNextDay(Item item) {
        defaultQualityModifier.ageItem(item);
        defaultSellInModifier.dayHasPassed(item);
    }
}
