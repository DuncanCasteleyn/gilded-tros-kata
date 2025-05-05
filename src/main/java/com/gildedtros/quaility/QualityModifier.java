package com.gildedtros.quaility;

import com.gildedtros.Item;

public interface QualityModifier {
    QualityModifier DEFAULT = DefaultQualityModifier.SINGLETON;

    void ageItem(Item item);
}
