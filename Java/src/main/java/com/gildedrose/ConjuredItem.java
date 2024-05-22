package com.gildedrose;

class ConjuredItem extends NormalUpdatableItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseQuality(2);
    }

    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }

    @Override
    public void handleExpired() {
        if (sellIn < 0) {
            decreaseQuality(2);
        }
    }
}
