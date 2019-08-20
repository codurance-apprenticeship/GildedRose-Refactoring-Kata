package com.gildedrose.goods;

public abstract class Goods {
    protected int quality;
    protected int sellIn;

    protected Goods(int sellIn, int quality) {
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public abstract void update();
    public abstract String getName();

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }
}
