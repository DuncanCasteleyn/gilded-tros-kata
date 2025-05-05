package com.gildedtros.quaility;

import com.gildedtros.Item;

public class InterestingBackStagePasQualityModifier implements QualityModifier {

    public static final InterestingBackStagePasQualityModifier SINGLETON = new InterestingBackStagePasQualityModifier();

    private InterestingBackStagePasQualityModifier() {
    }


    @Override public void ageItem(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
            return;
        }

        if(item.quality >= MAX_QUALITY) {
            return;
        }

        if (item.sellIn <= 10) {
            item.quality += 2;
        }

        if (item.sellIn <= 5) {
            item.quality += 1;
        }

        if(item.quality >= MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }
}
