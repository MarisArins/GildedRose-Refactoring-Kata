package com.gildedrose;

class BackstagePass extends NormalUpdatableItem {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality(1);
        if (sellIn < 11) {
            increaseQuality(1);
        }
        if (sellIn < 6) {
            increaseQuality(1);
        }
    }

    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }

    @Override
    public void handleExpired() {
        if (sellIn < 0) {
            quality = 0;
        }
    }
}
