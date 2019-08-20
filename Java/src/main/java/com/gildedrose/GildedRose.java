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

        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void updateSulfuras(Item item) {

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