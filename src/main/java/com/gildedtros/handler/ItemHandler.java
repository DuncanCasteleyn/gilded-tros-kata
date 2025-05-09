package com.gildedtros.handler;

import com.gildedtros.Item;

import java.util.Collection;
import java.util.List;

public interface ItemHandler {
    ItemHandler DEFAULT = DefaultItemHandler.SINGLETON;

    Collection<ItemHandler> NON_DEFAULT_HANDLERS = List.of(
            GoodWineHandler.SINGLETON,
            InterestingBackStagePassesHandler.SINGLETON,
            LegendaryItemHandler.SINGLETON,
            SmellyItemHandler.SINGLETON
    );

    boolean handles(Item item);

    void updateItemForNextDay(Item item);
}
