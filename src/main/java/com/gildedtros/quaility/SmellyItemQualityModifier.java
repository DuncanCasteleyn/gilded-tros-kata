package com.gildedtros.quaility;

import com.gildedtros.Item;

public class SmellyItemQualityModifier implements QualityModifier {
    public static final QualityModifier SINGLETON = new SmellyItemQualityModifier();

    private SmellyItemQualityModifier() {
    }

    @Override public void ageItem(Item item) {
        if (item.quality <= 0) {
            return;
        }

        item.quality -= 2;

        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
