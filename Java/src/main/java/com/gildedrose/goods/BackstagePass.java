package com.gildedrose.goods;

public class BackstagePass extends Goods {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void update() {

        if (isExpired()) {
            resetQualityToZero();
        } else {
            updateQuality();
        }

        deductSellIn();
    }

    private void updateQuality() {
        for (QualityForSellInRange qualityForSellInRange : QualityForSellInRange.values()) {
            if (qualityForSellInRange.isSellInWithinRange(this)) {
                this.quality += qualityForSellInRange.increaseToQuality;
                break;
            }
        }
    }

    private void resetQualityToZero() {
        this.quality = 0;
    }


    private enum QualityForSellInRange {
        ONE(Integer.MAX_VALUE, 10, 1),
        TWO(10, 5, 2),
        THREE(5, 0, 3);

        private final int upInclusive;
        private final int downExclusive;
        private final int increaseToQuality;

        QualityForSellInRange(int upInclusive, int downExclusive, int increaseToQuality) {
            this.upInclusive = upInclusive;
            this.downExclusive = downExclusive;
            this.increaseToQuality = increaseToQuality;
        }

        boolean isSellInWithinRange(Goods goods) {
            return goods.sellIn > this.downExclusive && goods.sellIn <= this.upInclusive;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
