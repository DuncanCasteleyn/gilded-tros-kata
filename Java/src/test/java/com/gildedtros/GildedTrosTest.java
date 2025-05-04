package com.gildedtros;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GildedTrosTest {

    Item[] AllItems = new Item[]{
            new Item("Ring of Cleansening Code", 10, 20),
            new Item("Good Wine", 2, 0),
            new Item("Elixir of the SOLID", 5, 7),
            new Item("B-DAWG Keychain", 0, 80),
            new Item("B-DAWG Keychain", -1, 80),
            new Item("Backstage passes for Re:Factor", 15, 20),
            new Item("Backstage passes for Re:Factor", 10, 49),
            new Item("Backstage passes for HAXX", 5, 49),
            // these smelly items do not work properly yet
            new Item("Duplicate Code", 3, 6),
            new Item("Long Methods", 3, 6),
            new Item("Ugly Variable Names", 3, 6)
    };

    @Test
    void updateQuality_WhenExecuted_QualityShouldNeverBeNegative() {
        // Given
        GildedTros app = new GildedTros(AllItems);

        // When
        app.updateQuality();

        // Then
        final int lowestQuality = Arrays.stream(app.items)
                                         .mapToInt(item -> item.quality)
                                         .min().orElseThrow(() -> new RuntimeException("No quality found"));

        assertTrue(lowestQuality >= 0);
    }

}
