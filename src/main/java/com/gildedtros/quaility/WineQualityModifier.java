package com.gildedtros.quaility;

import com.gildedtros.Item;

public class WineQualityModifier implements QualityModifier {
    public static WineQualityModifier SINGLETON = new WineQualityModifier();

    private WineQualityModifier() {
    }

    @Override
    public void ageItem(Item item) {
        if (item.quality >= MAX_QUALITY) {
            return;
        }

        item.quality += 1;

        if (item.quality >= MAX_QUALITY || item.sellIn > 0) {
            return;
        }

        item.quality += 1;
    }
}
