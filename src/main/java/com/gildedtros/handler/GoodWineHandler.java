package com.gildedtros.handler;

import com.gildedtros.Item;
import com.gildedtros.quaility.DefaultQualityModifier;
import com.gildedtros.quaility.QualityModifier;
import com.gildedtros.quaility.WineQualityModifier;
import com.gildedtros.sell.in.DefaultSellInModifier;
import com.gildedtros.sell.in.SellInModifier;

public class GoodWineHandler implements ItemHandler {
    public static final GoodWineHandler SINGLETON = new GoodWineHandler();

    private static final String GOOD_WINE = "Good Wine";

    private final QualityModifier qualityModifier = WineQualityModifier.SINGLETON;
    private final SellInModifier sellInModifier = DefaultSellInModifier.SINGLETON;

    private GoodWineHandler() {
    }

    @Override public boolean handles(Item item) {
        return GOOD_WINE.equals(item.name);
    }

    @Override public void updateItemForNextDay(Item item) {
        qualityModifier.ageItem(item);
        sellInModifier.dayHasPassed(item);
    }
}
