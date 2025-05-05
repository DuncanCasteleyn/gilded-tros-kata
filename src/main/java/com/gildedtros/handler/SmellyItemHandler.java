package com.gildedtros.handler;

import com.gildedtros.Item;
import com.gildedtros.quaility.QualityModifier;
import com.gildedtros.quaility.SmellyItemQualityModifier;
import com.gildedtros.sell.in.SellInModifier;

import java.util.Collection;
import java.util.List;

public class SmellyItemHandler implements ItemHandler {
    public static final SmellyItemHandler SINGLETON = new SmellyItemHandler();

    private static final Collection<String> SMELLY_ITEMS =List.of("Duplicate Code", "Long Methods", "Ugly Variable Names");

    private final QualityModifier qualityModifier = SmellyItemQualityModifier.SINGLETON;
    private final SellInModifier sellInModifier = SellInModifier.DEFAULT;

    private SmellyItemHandler() {
    }

    @Override public boolean handles(Item item) {
        return SMELLY_ITEMS.stream().anyMatch(s -> s.equals(item.name));
    }

    @Override public void updateItemForNextDay(Item item) {
        qualityModifier.ageItem(item);
        sellInModifier.dayHasPassed(item);
    }
}
