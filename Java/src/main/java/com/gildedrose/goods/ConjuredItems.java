package com.gildedrose.goods;

public class ConjuredItems extends Goods {

    public static final String PREFIX = "Conjured ";
    private static final int DEFAULT_QUALITY_DEPRECIATION = 2;
    private static final int TWO_FOLD_DEPRECIATION = 4;

    private String name;

    public ConjuredItems(String name, int sellIn, int quality) {
        super(sellIn, quality);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void update() {
        updateQuality();
        deductSellIn();
    }

    private void updateQuality() {
        if (isExpired()) {
            this.quality -= TWO_FOLD_DEPRECIATION;
        } else {
            this.quality -= DEFAULT_QUALITY_DEPRECIATION;
        }

        limitQualityOverDownLimit();
    }

    private void limitQualityOverDownLimit() {
        if (this.quality <= QUALITY_DOWNLIMIT) {
            this.quality = QUALITY_DOWNLIMIT;
        }
    }
}
