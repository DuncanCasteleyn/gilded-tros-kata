package com.gildedtros;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedTrosTest {

    private static final int LEGENDARY_ITEM_QUALITY = 80;
    private static final int MAX_QUALITY = 50;

    @Test
    void updateQuality_WhenExecuted_QualityShouldNeverBeNegative() {
        // Given
        Item[] items = new Item[]{
                new Item("Ring of Cleansening Code", 10, 0),
                new Item("Good Wine", 2, 0),
                new Item("Elixir of the SOLID", 5, 0),
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80),
                new Item("Backstage passes for Re:Factor", 15, 0),
                new Item("Backstage passes for Re:Factor", 10, 0),
                new Item("Backstage passes for HAXX", 5, 0),
                // these smelly items do not work properly yet
                new Item("Duplicate Code", 3, 0),
                new Item("Long Methods", 3, 0),
                new Item("Ugly Variable Names", 3, 0)
        };

        GildedTros app = new GildedTros(items);

        // When
        app.updateQuality();

        // Then
        final int lowestQuality = Arrays.stream(app.items)
                                        .mapToInt(item -> item.quality)
                                        .min()
                                        .orElseThrow(() -> new IllegalStateException("No quality found"));

        assertTrue(lowestQuality >= 0);
    }

    @Test
    void updateQuality_WhenExecuted_NothingShouldChangeForLegendaryItem() {
        // Given
        Item[] AllItems = new Item[]{
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80)
        };

        GildedTros app = new GildedTros(AllItems);

        // When
        app.updateQuality();

        // Then
        assertEquals(LEGENDARY_ITEM_QUALITY, app.items[0].quality);
        assertEquals(LEGENDARY_ITEM_QUALITY, app.items[1].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(-1, app.items[1].sellIn);
    }

    @Test
    void updateQuality_WhenExecuted_QualityShouldNeverIncreaseAboveFifty() {
        // Given
        Item[] AllItems = new Item[]{
                new Item("Good Wine", 2, MAX_QUALITY),
                new Item("Good Wine", 2, 49),
                new Item("Backstage passes for Re:Factor", 10, 49),
                new Item("Backstage passes for Re:Factor", 10, 48),
                new Item("Backstage passes for HAXX", 5, 49),
                new Item("Backstage passes for HAXX", 5, 47)
        };

        GildedTros app = new GildedTros(AllItems);

        // When
        app.updateQuality();

        // Then
        assertEquals(MAX_QUALITY, app.items[0].quality);
        assertEquals(MAX_QUALITY, app.items[1].quality);
        assertEquals(MAX_QUALITY, app.items[2].quality);
        assertEquals(MAX_QUALITY, app.items[3].quality);
        assertEquals(MAX_QUALITY, app.items[4].quality);
        assertEquals(MAX_QUALITY, app.items[5].quality);
    }

    @Test
    void updateQuality_WhenExecuted_BackStagePassesShouldIncreaseQualityByTwoWhenTenDaysOrLess() {
        // Given
        Item[] AllItems = new Item[]{
                new Item("Backstage passes for Re:Factor", 10, 10),
                new Item("Backstage passes for Re:Factor", 9, 20),
                new Item("Backstage passes for HAXX", 7, 20),
                new Item("Backstage passes for HAXX", 6, 10)
        };

        GildedTros app = new GildedTros(AllItems);

        // When
        app.updateQuality();

        // Then
        assertEquals(12, app.items[0].quality);
        assertEquals(22, app.items[1].quality);
        assertEquals(22, app.items[2].quality);
        assertEquals(12, app.items[3].quality);
    }

    @Test
    void updateQuality_WhenExecuted_BackStagePassesShouldIncreaseQualityByTwoWhenFiveDaysOrLess() {
        // Given
        Item[] AllItems = new Item[]{
                new Item("Backstage passes for Re:Factor", 5, 10),
                new Item("Backstage passes for Re:Factor", 4, 20),
                new Item("Backstage passes for HAXX", 2, 20),
                new Item("Backstage passes for HAXX", 1, 10)
        };

        GildedTros app = new GildedTros(AllItems);

        // When
        app.updateQuality();

        // Then
        assertEquals(13, app.items[0].quality);
        assertEquals(23, app.items[1].quality);
        assertEquals(23, app.items[2].quality);
        assertEquals(13, app.items[3].quality);
    }

    @Test
    void updateQuality_WhenExecuted_BackStagePassesQualityIsZeroAfterEvent() {
        // Given
        Item[] AllItems = new Item[]{
                new Item("Backstage passes for Re:Factor", 0, 20),
                new Item("Backstage passes for Re:Factor", 0, 40),
                new Item("Backstage passes for HAXX", 0, 50),
                new Item("Backstage passes for HAXX", 0, 10)
        };

        GildedTros app = new GildedTros(AllItems);

        // When
        app.updateQuality();

        // Then
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
        assertEquals(0, app.items[3].quality);
    }
}
