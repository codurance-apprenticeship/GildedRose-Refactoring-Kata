package com.gildedrose;

import com.gildedrose.goods.AgedBrie;
import com.gildedrose.goods.BackstagePass;
import com.gildedrose.goods.Sulfuras;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class GildedRoseTest {

    @Test
    public void combinatorial_test() {
        String[] names = {
                AgedBrie.NAME,
                BackstagePass.NAME,
                Sulfuras.NAME,
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
