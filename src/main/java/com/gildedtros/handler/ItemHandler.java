package com.gildedtros.handler;

import com.gildedtros.Item;

import java.util.Collection;
import java.util.List;

public interface ItemHandler {
    Collection<ItemHandler> handlers = List.of(
            DefaultItemHandler.SINGLETON
    );

    boolean handles(Item item);

    void updateItemForNextDay(Item item);
}
