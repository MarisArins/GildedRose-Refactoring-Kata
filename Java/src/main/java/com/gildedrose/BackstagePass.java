package com.gildedrose;

class BackstagePass extends RegularItem {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        updateQuality(1);
        if (sellIn < 11) {
            updateQuality(1);
        }
        if (sellIn < 6) {
            updateQuality(1);
        }
    }

    @Override
    protected void handleExpired() {
        quality = 0;
    }
}
