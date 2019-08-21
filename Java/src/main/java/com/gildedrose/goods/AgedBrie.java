package com.gildedrose.goods;

public class AgedBrie extends Goods {
    public final static String NAME = "Aged Brie";
    private static final int DEFAULT_QUALITY_INCREASE = 1;
    private static final int TWO_FOLD_QUALITY_INCREASE = 2;

    public AgedBrie(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {

        updateQuality();

        deductSellIn();

        keepQualityUnderUplimit();
    }

    private void updateQuality() {
        // FIXME: documentation doesn't cover the case that aged brie's quality get doubled after expire
        if (isExpired()) {
            this.quality += TWO_FOLD_QUALITY_INCREASE;
        } else {
            this.quality += DEFAULT_QUALITY_INCREASE;
        }
    }

    private void keepQualityUnderUplimit() {
        if (this.quality > UPLIMIT_FOR_QUALITY) {
            this.quality = UPLIMIT_FOR_QUALITY;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
