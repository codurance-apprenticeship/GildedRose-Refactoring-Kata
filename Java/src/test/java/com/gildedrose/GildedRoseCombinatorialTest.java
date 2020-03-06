package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
// remove *.approved.txt to generate the golden master snapshot. Rename it to xxx.approved.txt to use it.
public class GildedRoseCombinatorialTest {

    @Test
    public void combinatorial_test() {
        String[] names = {
                "Aged Brie",
                "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros",
                "Regular Items 1",
                "Regular Items 2"
        };

        Integer[] range = IntStream.range(-100, 101).boxed().toArray(Integer[]::new);
        CombinationApprovals.verifyAllCombinations(
                this::getItemResultAfterUpdate,
                names,
                range,
                range
        );
    }

    private String getItemResultAfterUpdate(String name, int sellIn, int quality) {
        Item[] items = {new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return items[0].toString();
    }


}
