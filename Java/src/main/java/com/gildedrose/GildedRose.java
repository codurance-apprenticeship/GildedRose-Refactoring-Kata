package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item) &&
                !isBackstagePasses(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (isBackstagePasses(item)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePasses(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;;
                    }
                }
            }
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}