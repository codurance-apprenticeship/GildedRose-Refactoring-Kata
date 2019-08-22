package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.stream.IntStream;

public class GildedRoseTest {

//    @Test
//    public void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }

    @Test
    public void combinatorial_test() {
        String[] names= {
                GildedRose.AGED_BRIE,
                GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,
                GildedRose.SULFURAS_HAND_OF_RAGNAROS,
                "Regular Items 1",
                "Regular Items 2"
        };

        Integer[] range = IntStream.range(-100, 101).boxed().toArray(Integer[]::new);
        // -100 ~ 100
        CombinationApprovals.verifyAllCombinations(
                this::getItemResultAfterUpdate,
                names,
                range,
                range
        );

    }

    private String getItemResultAfterUpdate(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return items[0].toString();
    }


}
