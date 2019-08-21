package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellInRemaining(item);

            switch (item.name){
                case "Aged Brie":
                    updateBrieQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstageQuality(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    updateRegularQuality(item);
                    break;
            }
        }
    }

    private void updateSellInRemaining(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    private void updateRegularQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }

    private void updateBackstageQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
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
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateBrieQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 0) {
                item.quality++;
            }
        }
    }

}