package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseShould {

    @Test
    public void reduce_quality_of_regular_item_by_one_after_one_day() {
        int initialQuality = 20;
        Item item = new Item("regular item", 10, initialQuality);
        Item[] items = new Item[]{item};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        int expectedQuality = 19;
        int actualQuality = item.quality;
        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void reduce_sell_in_date_by_one_after_one_day() {
        int initialSellIn = 10;
        Item item = new Item("regular item", initialSellIn, 20);
        Item[] items = new Item[]{item};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        int expectedSellIn = 9;
        int actualSellIn = item.sellIn;
        assertEquals(expectedSellIn, actualSellIn);
    }

}
