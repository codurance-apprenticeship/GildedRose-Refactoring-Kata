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
        Item[] items = new Item[] {simple_item};
        GildedRose app = new GildedRose(items);

        assertEquals("Simple Item", simple_item.name);
        assertEquals(10, simple_item.sellIn);
        assertEquals(20, simple_item.quality);
    }

    private static Stream<Arguments> provideItems(){
        return Stream.of(
                (Arguments.of(new Item("Item1",10,20),new Item("Item1",10,20)))
        );
    }

    @ParameterizedTest
    @MethodSource("proviceItems")
    public void cover_all_functionality(Item initalItem, Item expectedItem){
        Item item = initalItem;
        Item[] items = new Item[] {item};
        GildedRose app = new GildedRose(items);

        assertEquals(expectedItem.name, item.name);
        assertEquals(expectedItem.sellIn, item.sellIn);
        assertEquals(expectedItem.quality, item.quality);
    }
}
