package com.gildedrose;

class AgedItem extends RegularItem {
    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        updateQuality(1);
    }

    @Override
    protected void handleExpired() {
        updateQuality(1);
    }
}
