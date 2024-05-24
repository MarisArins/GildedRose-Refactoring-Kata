package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testSulfurasAlways80Quality() {
        Item[] items = new Item[]{new LegendaryItem("Sulfuras, Hand of Ragnaros", 3, 80)};
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        //never has to be sold
        assertEquals(3, app.items[0].sellIn);
        //never decreases quality
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQuality() {
        Item[] items = new Item[]{
            new AgedItem("Aged Brie", 3, 10),
            new AgedItem("Aged Brie", 1, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(0, app.items[0].sellIn);
        // increase by 1:1:1
        assertEquals(13, app.items[0].quality);

        assertEquals(-2, app.items[1].sellIn);
        // increase by 1:2:2
        assertEquals(15, app.items[1].quality);
    }

    @Test
    void testAgedBrieIncreasesQualityUpTo50() {
        Item[] items = new Item[]{
            new AgedItem("Aged Brie", 3, 48),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 40),
            new RegularItem("Crystal Sword", 6, 48)};
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(-2, app.items[0].sellIn);
        // increase by 1:1:0:0:0
        assertEquals(50, app.items[0].quality);

        assertEquals(0, app.items[1].sellIn);
        // increase by 3:3:3:1:0
        assertEquals(50, app.items[1].quality);

        assertEquals(1, app.items[2].sellIn);
        // decrease by 1:1:1:1:1
        assertEquals(43, app.items[2].quality);
    }

    @Test
    void testRandomItemDecreasesQuality() {
        Item[] items = new Item[]{new RegularItem("Crystal Sword", 5, 25)};
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(2, app.items[0].sellIn);
        //  reducing by 1:1:1
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testRandomItemDecreasesQuality2xFasterAfterDueDate() {
        Item[] items = new Item[]{new RegularItem("Crystal Sword", 1, 25)};
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(-2, app.items[0].sellIn);
        //  reducing by 1:2:2
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void testQualityNeverIsNegative() {
        Item[] items = new Item[]{new RegularItem("Crystal Sword", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(-4, app.items[0].sellIn);
        //  reducing by 1:2:2:0:0
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstagePass0QualityAfterConcert() {
        Item[] items = new Item[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 3, 20)};
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(0, app.items[0].sellIn);
        // increase by 3:3:3
        assertEquals(29, app.items[0].quality);

        app.updateInventory();
        assertEquals(-1, app.items[0].sellIn);
        // set to 0
        assertEquals(0, app.items[0].quality);

        app.updateInventory();
        assertEquals(-2, app.items[0].sellIn);
        // set to 0
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityIncreasePatterns() {
        Item[] items = new Item[]{
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 12, 20),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 7, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(9, app.items[0].sellIn);
        // increase by 1:1:2
        assertEquals(24, app.items[0].quality);

        assertEquals(4, app.items[1].sellIn);
        // increase by 2:2:3
        assertEquals(27, app.items[1].quality);
    }

    @Test
    void testConjuredItemDecreasesQuality() {
        Item[] items = new Item[]{
            new ConjuredItem("Conjured Mana Cake", 5, 25),
            new ConjuredItem("Conjured Mana Cake", 5, 5)
        };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(2, app.items[0].sellIn);
        //  reducing by 2:2:2
        assertEquals(19, app.items[0].quality);

        assertEquals(2, app.items[1].sellIn);
        //  reducing by 2:2:1
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void testConjuredItemDecreasesQuality2xFasterAfterDueDate() {
        Item[] items = new Item[]{
            new ConjuredItem("Conjured Mana Cake", 1, 25),
            new ConjuredItem("Conjured Mana Cake", 1, 5)
        };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        app.updateInventory();
        app.updateInventory();
        assertEquals(-2, app.items[0].sellIn);
        //  reducing by 2:4:4
        assertEquals(15, app.items[0].quality);

        assertEquals(-2, app.items[1].sellIn);
        //  reducing by 2:1:0
        assertEquals(0, app.items[1].quality);
    }

}
