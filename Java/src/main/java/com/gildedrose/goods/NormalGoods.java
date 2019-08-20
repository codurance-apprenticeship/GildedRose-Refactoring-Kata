package com.gildedrose.goods;

public class NormalGoods extends Goods{

    private String name;

    public NormalGoods(String name, int sellIn, int quality) {
        super(sellIn, quality);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update() {
        if (this.sellIn > 0) {
            this.quality -= 1;
        } else {
            this.quality -= 2;
        }
        this.sellIn -= 1;
        if (this.quality <= 0) {
            this.quality = 0;
        }
    }
}
