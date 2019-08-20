package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GolderMaster {

    @Test
    public void same_as_snapshot() {
        Item[] items = new Item[]{
                // At the end of each day our system lowers both values for every item
                new Item("Regular Item", 10, 20),

                // Once the sell by date has passed, Quality degrades twice as fast
                new Item("Regular Item", 0, 20),
                new Item("Regular Item", -1, 20),

                // The Quality of an item is never negative
                new Item("Regular Item", 10, 0),

                // "Aged Brie" actually increases in Quality the older it gets
                new Item("Aged Brie", 10, 10),
                new Item("Aged Brie", 0, 10),

                // The Quality of an item is never more than 50
                new Item("Aged Brie", 10, 50),

                // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                new Item("Sulfuras, Hand of Ragnaros", 10, 40),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),


                // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
                //  Quality increases by 2 when there are 10 days or less
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                //  by 3 when there are 5 days or less but
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                //Quality drops to 0 after the concert
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20),

                // this conjured item does not work properly yet
                // TODO: add case for conjured item
                // new Item("Conjured Mana Cake", 3, 6)

        };

        GildedRose app = new GildedRose(items);

        int days = 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < days; i++) {
            sb.append("-------- day " + i + " --------").append("\n");
            sb.append("name, sellIn, quality").append("\n");;
            for (Item item : items) {
                sb.append(item).append("\n");;
            }
            app.updateQuality();
        }

        assertEquals(SNAPSHOT, sb.toString());
    }

    private static final String SNAPSHOT =
    "-------- day 0 --------\n"+
            "name, sellIn, quality\n"+
            "Regular Item, 10, 20\n"+
            "Regular Item, 0, 20\n"+
            "Regular Item, -1, 0\n"+
            "Regular Item, 10, 0\n"+
            "Aged Brie, 10, 10\n"+
            "Aged Brie, 0, 10\n"+
            "Aged Brie, 10, 50\n"+
            "Sulfuras, Hand of Ragnaros, 10, 40\n"+
            "Sulfuras, Hand of Ragnaros, 10, 80\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 11, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 10, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 6, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 5, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 1, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 0, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, -1, 20\n"+
            "-------- day 1 --------\n"+
            "name, sellIn, quality\n"+
            "Regular Item, 9, 19\n"+
            "Regular Item, -1, 18\n"+
            "Regular Item, -2, 18\n"+
            "Regular Item, 9, 0\n"+
            "Aged Brie, 9, 11\n"+
            "Aged Brie, -1, 12\n"+
            "Aged Brie, 9, 50\n"+
            "Sulfuras, Hand of Ragnaros, 10, 40\n"+
            "Sulfuras, Hand of Ragnaros, 10, 80\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n"+
            "Backstage passes to a TAFKAL80ETC concert, 10, 21\n"+
            "Backstage passes to a TAFKAL80ETC concert, 9, 22\n"+
            "Backstage passes to a TAFKAL80ETC concert, 5, 22\n"+
            "Backstage passes to a TAFKAL80ETC concert, 4, 23\n"+
            "Backstage passes to a TAFKAL80ETC concert, 0, 23\n"+
            "Backstage passes to a TAFKAL80ETC concert, -1, 0\n"+
            "Backstage passes to a TAFKAL80ETC concert, -2, 0\n";


}
