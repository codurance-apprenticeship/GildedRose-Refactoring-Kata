package com.gildedrose;

import com.gildedrose.goods.ConjuredItems;
import com.gildedrose.goods.Goods;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class GoodsFactoryShould {

    @Test
    void getConjuredItemdIfStartsWithConjured() {
        GoodsFactory goodsFactory = new GoodsFactory();
        Goods goods = goodsFactory.getGoods(new Item("Conjured Item", 0, 0));
        assertThat(goods, is(instanceOf(ConjuredItems.class)));
    }
}