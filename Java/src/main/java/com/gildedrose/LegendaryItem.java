package com.gildedrose;

class LegendaryItem extends NormalUpdatableItem {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // LegendaryItem does not change in quality
    }

    @Override
    public void updateSellIn() {
        // LegendaryItem does not change sellIn
    }

    @Override
    public void handleExpired() {
        // LegendaryItem does not expire
    }
}
