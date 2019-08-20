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

    /*
    "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

    "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works correctly. However, do not alter the Item class or Items property as those belong to the goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.

     */
    private static Stream<Arguments> provideItems() {
        return Stream.of(
            Arguments.of(new Item("simple Item", 10, 20), new Item("simple Item", 9, 19)),
            Arguments.of(new Item("outdated Item", -10, 20), new Item("outdated Item", -11, 18)),
            Arguments.of(new Item("zero quality Item", -10, 0), new Item("zero quality Item", -11, 0)),
            Arguments.of(new Item("Aged Brie", 10, 0), new Item("Aged Brie", 9, 1)),
            Arguments.of(new Item("Aged Brie", -10, 0), new Item("Aged Brie", -11, 2)),
            Arguments.of(new Item("overqualified item", 1, 80), new Item("overqualified item", 0, 79)),
            Arguments.of(new Item("Sulfuras, Hand of Ragnaros", 5, 25), new Item("Sulfuras, Hand of Ragnaros", 5, 25))
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
