package com.gildedtros.quaility;

import com.gildedtros.Item;

public class LegendaryItemQualityModifier implements QualityModifier {
    public static final LegendaryItemQualityModifier SINGLETON = new LegendaryItemQualityModifier();

    private static final int LEGENDARY_ITEM_QUALITY = 80;

    private LegendaryItemQualityModifier() {
    }

    @Override
    public void ageItem(Item item) {
        item.quality = LEGENDARY_ITEM_QUALITY;
    }
}
