package com.gildedrose;

class ConjuredItem extends RegularItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        updateQuality(-2);
    }

    @Override
    protected void handleExpired() {
        updateQuality(-2);
    }
}
