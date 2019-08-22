package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case Sulfuras.SULFURAS_HAND_OF_RAGNAROS:
                return new Sulfuras(sellIn, quality);

            case AgedBrie.AGED_BRIE:
                return new AgedBrie(sellIn, quality);

            case BackstagePass.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackstagePass(sellIn, quality);

            case Conjured.CONJURED_MANA_CAKE:
                return new Conjured(sellIn, quality);
        }

        return new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void update() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }
}
