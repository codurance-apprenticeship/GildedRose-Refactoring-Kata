package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseShould {

    @Test
    public void reduce_quality_of_item() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        Item[] items = new Item[]{item};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals();
    }
}
