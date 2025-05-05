package com.gildedtros.handler;

import com.gildedtros.Item;
import com.gildedtros.quaility.BackStagePasModifier;
import com.gildedtros.quaility.QualityModifier;
import com.gildedtros.sell.in.SellInModifier;

import java.util.Collection;
import java.util.List;

public class BackStagePassesHandler extends DefaultItemHandler {
    public static final BackStagePassesHandler SINGLETON = new BackStagePassesHandler();

    private static final Collection<String> INTERESTING_BACKSTAGE_PASSES = List.of(
            "Backstage passes for Re:Factor",
            "Backstage passes for HAXX"
    );

    private final QualityModifier qualityModifier = BackStagePasModifier.SINGLETON;
    private final SellInModifier sellInModifier = SellInModifier.DEFAULT;

    @Override public boolean handles(Item item) {
        return INTERESTING_BACKSTAGE_PASSES
                .stream()
                .anyMatch(backstagePass -> backstagePass.equals(item.name));
    }

    @Override public void updateItemForNextDay(Item item) {
        if (item.sellIn <= 10) {
            qualityModifier.ageItem(item);
            sellInModifier.dayHasPassed(item);

            return;
        }

        super.updateItemForNextDay(item);
    }
}
