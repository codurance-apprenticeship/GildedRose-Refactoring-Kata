package com.gildedrose.goods;

public class BackstagePass extends Goods {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {
        if (this.sellIn > 10) {
            this.quality += 1;
        } else if (this.sellIn > 5) {
            this.quality += 2;
        } else if (this.sellIn > 0){
            this.quality += 3;
        } else {
            this.quality = 0;
        }
        this.sellIn -=1;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
