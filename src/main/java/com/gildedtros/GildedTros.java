package com.gildedtros;

import com.gildedtros.handler.ItemHandler;

class GildedTros {


    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final int FIFTY = 50;
    private static final int ELEVEN = 11;
    private static final int SIX = 6;

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

/*    @Deprecated(forRemoval = true)
    private static void LegacyMethod(Item item) {
        if (!item.name.equals(GOOD_WINE)
            && !item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR)
            && !item.name.equals(BACKSTAGE_PASSES_FOR_HAXX)) {
            if (item.quality > 0) {
                if (!item.name.equals(B_DAWG_KEYCHAIN)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < FIFTY) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR) || item.name.equals(
                        BACKSTAGE_PASSES_FOR_HAXX)) {
                    if (item.sellIn < ELEVEN) {
                        if (item.quality < FIFTY) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < SIX) {
                        if (item.quality < FIFTY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals(B_DAWG_KEYCHAIN)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(GOOD_WINE)) {
                if (!"Backstage passes for Re:Factor".equals(item.name) &&
                    !"Backstage passes for HAXX".equals(item.name)) {
                    if (item.quality > 0) {
                        if (!"B-DAWG Keychain".equals(item.name)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < FIFTY) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }*/
}
