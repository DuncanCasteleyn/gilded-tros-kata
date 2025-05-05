package com.gildedtros;

import com.gildedtros.handler.ItemHandler;

class GildedTros {

    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateItemsAfterDayPassed() {
        for (Item item : items) {
            final ItemHandler itemHandler = getItemHandlerForItem(item);

            itemHandler.updateItemForNextDay(item);
        }
    }

    public ItemHandler getItemHandlerForItem(Item item) {
        return ItemHandler.NON_DEFAULT_HANDLERS
                .stream()
                .filter(itemHandler -> itemHandler.handles(item))
                .findFirst()
                .orElse(ItemHandler.DEFAULT);
    }
}
