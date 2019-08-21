package com.gildedrose;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class GildedRoseMasterGold {
    @Test
    public void add_item_with_proper_values() {
        Item simple_item = new Item("Simple Item", 10, 20);
        Item[] items = new Item[]{simple_item};
        GildedRose app = new GildedRose(items);

        assertEquals("Simple Item", simple_item.name);
        assertEquals(10, simple_item.sellIn);
        assertEquals(20, simple_item.quality);
    }

    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(new Item("simple Item", 10, 20), new Item("simple Item", 9, 19)),
            Arguments.of(new Item("outdated Item", -10, 20), new Item("outdated Item", -11, 18)),
            Arguments.of(new Item("zero quality Item", -10, 0), new Item("zero quality Item", -11, 0)),
            Arguments.of(new Item("Aged Brie", 10, 0), new Item("Aged Brie", 9, 1)),
            Arguments.of(new Item("Aged Brie", -10, 0), new Item("Aged Brie", -11, 2)),
            Arguments.of(new Item("Aged Brie", 15, 50), new Item("Aged Brie", 14, 50)),
            Arguments.of(new Item("overqualified item", 1, 80), new Item("overqualified item", 0, 79)),
            Arguments.of(new Item("Sulfuras, Hand of Ragnaros", 5, 25), new Item("Sulfuras, Hand of Ragnaros", 5, 25)),
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 25), new Item("Backstage passes to a TAFKAL80ETC concert", 14, 26)),
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25), new Item("Backstage passes to a TAFKAL80ETC concert", 9, 27)),
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25), new Item("Backstage passes to a TAFKAL80ETC concert", 4, 28)),
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 28), new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0)),
             Arguments.of(new Item("Conjured Mana Cake", 1, 28), new Item("Conjured Mana Cake", 0, 26))

        );
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    public void cover_all_functionality(Item initialItem, Item expectedItem) {
        Item item = initialItem;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(expectedItem.name, item.name);
        assertEquals(expectedItem.sellIn, item.sellIn);
        assertEquals(expectedItem.quality, item.quality);
    }


}
