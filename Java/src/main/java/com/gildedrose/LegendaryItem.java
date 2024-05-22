package com.gildedrose;

class LegendaryItem extends NormalUpdatableItem {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // Sulfuras does not change in quality
    }

    @Override
    public void updateSellIn() {
        // Sulfuras does not change sellIn
    }

    @Override
    public void handleExpired() {
        // Sulfuras does not expire
    }
}
