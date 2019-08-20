package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private static final int TOP_QUALITY = 50;
    Item[] items;
    String[] SPECIAL_ITEMS = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
        }
    }

    private void updateQuality(Item item) {
        if (!Arrays.asList(SPECIAL_ITEMS).contains(item.name)) {
            updateNormalItem(item);
            return;
        }
        if (item.name.equals("Aged Brie")) {
            updateAgedBrie(item);
            return;
        }

        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            updateSulfuras(item);
            return;
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstage(item);
        }
    }

    private void updateBackstage(Item item) {
        if (item.sellIn > 10) {
            item.quality += 1;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0){
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        item.sellIn -=1;
    }

    private void updateSulfuras(Item item) {
        //Legendary Item, nothing changes!
    }

    private void updateAgedBrie(Item item) {
        // FIXME: documentation doesn't cover the case that aged brie's quality get doubled after expire
        if (item.sellIn > 0) {
            item.quality += 1;
        } else {
            item.quality += 2;
        }

        item.sellIn -= 1;

        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    private void updateNormalItem(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 1;
        } else {
            item.quality -= 2;
        }
        item.sellIn -= 1;
        if (item.quality <= 0) {
            item.quality = 0;
        }
    }
}