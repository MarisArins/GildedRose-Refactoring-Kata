package com.gildedrose;

public class ItemFactory {

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new AgedItem(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(name, sellIn, quality);
            case "Conjured Mana Cake":
                return new ConjuredItem(name, sellIn, quality);
            default:
                return new NormalUpdatableItem(name, sellIn, quality);
        }
    }
}
