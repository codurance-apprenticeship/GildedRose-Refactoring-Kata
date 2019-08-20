package com.gildedrose;

import com.gildedrose.goods.Goods;

public class ItemFactory {
    public Item getItem(Goods goods) {
        return new Item(goods.getName(), goods.getSellIn(), goods.getQuality());
    }
}
