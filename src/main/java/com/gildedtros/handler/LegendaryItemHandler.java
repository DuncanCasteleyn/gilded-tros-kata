package com.gildedtros.handler;

import com.gildedtros.Item;
import com.gildedtros.quaility.LegendaryItemQualityModifier;
import com.gildedtros.quaility.QualityModifier;
import com.gildedtros.sell.in.LegendaryItemSelInModifier;
import com.gildedtros.sell.in.SellInModifier;

import java.util.Collection;
import java.util.List;

public class LegendaryItemHandler implements ItemHandler {
    public static final ItemHandler SINGLETON = new LegendaryItemHandler();

    private final static Collection<String> LEGENDARY_ITEMS = List.of("B-DAWG Keychain");

    private final QualityModifier qualityModifier = LegendaryItemQualityModifier.SINGLETON;
    private final SellInModifier sellInModifier = LegendaryItemSelInModifier.SINGLETON;

    private LegendaryItemHandler() {
    }

    @Override public boolean handles(Item item) {
        return LEGENDARY_ITEMS.stream()
                              .anyMatch(s -> s.equals(item.name));
    }

    @Override public void updateItemForNextDay(Item item) {

    }
}
