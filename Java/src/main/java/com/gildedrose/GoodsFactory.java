package com.gildedrose;

import com.gildedrose.goods.*;

public class GoodsFactory {
    Goods getGoods(Item item) {
        switch (item.name){
            case AgedBrie.NAME:
                return new AgedBrie(item.sellIn, item.quality);
            case Sulfuras.NAME:
                return new Sulfuras(item.sellIn, item.quality);
            case BackstagePass.NAME:
                return new BackstagePass(item.sellIn, item.quality);
            default:
                return new NormalGoods(item.name, item.sellIn, item.quality);
        }

    }
}
