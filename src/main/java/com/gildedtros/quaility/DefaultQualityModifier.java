package com.gildedtros.quaility;

import com.gildedtros.Item;

public class DefaultQualityModifier implements QualityModifier {
    public static DefaultQualityModifier SINGLETON = new DefaultQualityModifier();

    private DefaultQualityModifier() {
    }

    @Override public void ageItem(Item item) {

    }
}
