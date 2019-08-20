package com.gildedrose.goods;

public class AgedBrie extends Goods {
    public final static String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        // FIXME: documentation doesn't cover the case that aged brie's quality get doubled after expire
        if (this.sellIn > 0) {
            this.quality += 1;
        } else {
            this.quality += 2;
        }

        this.sellIn -= 1;

        if (this.quality > 50) {
            this.quality = 50;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
