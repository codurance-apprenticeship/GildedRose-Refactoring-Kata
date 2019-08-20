package com.gildedrose;

import com.gildedrose.goods.Goods;

class GildedRose {
    private final GoodsFactory goodsFactory;
    private Item[] items;
    private final ItemFactory itemFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        this.goodsFactory = new GoodsFactory();
        this.itemFactory = new ItemFactory();
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Goods goods = goodsFactory.getGoods(items[i]);
            goods.update();
            items[i] = itemFactory.getItem(goods);
        }
    }
}