package com.gildedrose;

public class Conjured extends Item {

    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    @Override
    void update() {
        if (quality > 0) {
            quality = quality - 2;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 2;
            }
        }
    }

    Conjured(int sellIn, int quality) {
        super(CONJURED_MANA_CAKE, sellIn, quality);
    }
}
