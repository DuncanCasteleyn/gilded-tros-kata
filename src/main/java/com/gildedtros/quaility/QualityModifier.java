package com.gildedtros.quaility;

import com.gildedtros.Item;

public interface QualityModifier {
    int MAX_QUALITY = 50;

    QualityModifier DEFAULT = DefaultQualityModifier.SINGLETON;


    void ageItem(Item item);
}
