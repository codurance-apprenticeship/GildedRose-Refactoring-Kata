package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class ConjuredItemsShould {
    @Test
    void degrade_quality_by_2_before_expire() {
        Item[] items = {
                new Item("Conjured Cake",10,10)
        };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(items[0].quality, is(equalTo(8)));
    }

    @Test
    void degrade_quality_by_4_after_expire() {
        Item[] items = {
                new Item("Conjured Cake",0,10)
        };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(items[0].quality, is(equalTo(6)));
    }
}
