package com.gildedtros.quaility;

import com.gildedtros.Item;

public class DefaultQualityModifier implements QualityModifier {
    public static DefaultQualityModifier SINGLETON = new DefaultQualityModifier();


    private DefaultQualityModifier() {
    }

    @Override public void ageItem(Item item) {
        if (item.quality <= 0) {
            return;
        }

        item.quality -= 1;

        if (item.sellIn <= 0) {
            item.quality -= 1;
        }
    }
}
