package com.gildedrose.goods;

public class Sulfuras extends Goods {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        // do nothing
    }

    @Override
    public String getName() {
        return NAME;
    }
}
