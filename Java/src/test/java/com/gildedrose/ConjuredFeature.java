package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredFeature {
    @Test
    public void decrease_quality_by_two() {
        Item[] items = new Item[] {
                Item.createItem("Conjured Mana Cake", 10, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, items[0].quality);
    }

    @Test
    public void decrease_quality_by_four_when_the_item_is_expired() {
        Item[] items = new Item[] {
                Item.createItem("Conjured Mana Cake", -10, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, items[0].quality);
    }
}
