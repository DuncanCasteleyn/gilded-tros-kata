package com.gildedtros;

class GildedTros {

    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final int FIFTY = 50;
    private static final int ELEVEN = 11;
    private static final int SIX = 6;

    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(GOOD_WINE)
                && !items[i].name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR)
                && !items[i].name.equals(BACKSTAGE_PASSES_FOR_HAXX)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < FIFTY) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR) || items[i].name.equals(
                            BACKSTAGE_PASSES_FOR_HAXX)) {
                        if (items[i].sellIn < ELEVEN) {
                            if (items[i].quality < FIFTY) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < SIX) {
                            if (items[i].quality < FIFTY) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(GOOD_WINE)) {
                    if (!"Backstage passes for Re:Factor".equals(items[i].name) &&
                        !"Backstage passes for HAXX".equals(items[i].name)) {
                        if (items[i].quality > 0) {
                            if (!"B-DAWG Keychain".equals(items[i].name)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < FIFTY) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
