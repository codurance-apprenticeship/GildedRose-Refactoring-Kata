package com.gildedrose.goods;

public abstract class Goods {
    static final int UPLIMIT_FOR_QUALITY = 50;
    static final int QUALITY_DOWNLIMIT = 0;
    protected int quality;
    protected int sellIn;

    Goods(int sellIn, int quality) {
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public abstract void update();

    boolean isExpired() {
        return this.sellIn <= 0;
    }

    void deductSellIn() {
        this.sellIn -= 1;
    }

    public abstract String getName();

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }
}
