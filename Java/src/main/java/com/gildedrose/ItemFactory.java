package com.gildedrose;

import com.gildedrose.goods.Goods;

class ItemFactory {
    Item getItem(Goods goods) {
        return new Item(goods.getName(), goods.getSellIn(), goods.getQuality());
    }
}
