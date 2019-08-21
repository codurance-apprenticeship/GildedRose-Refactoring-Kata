package com.gildedrose.goods;

public class NormalGoods extends Goods {

    private static final int DEFAULT_QUALITY_DEPRECIATION = 1;
    private static final int TWO_FOLD_DEPRECIATION = 2;

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
        updateQuality();

        deductSellIn();

        limitQualityOverDownLimit();
    }

    private void updateQuality() {
        if (isExpired()) {
            this.quality -= TWO_FOLD_DEPRECIATION;
        } else {
            this.quality -= DEFAULT_QUALITY_DEPRECIATION;
        }
    }

    private void limitQualityOverDownLimit() {
        if (this.quality <= QUALITY_DOWNLIMIT) {
            this.quality = QUALITY_DOWNLIMIT;
        }
    }
}
