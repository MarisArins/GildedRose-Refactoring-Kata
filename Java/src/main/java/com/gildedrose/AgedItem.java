package com.gildedrose;

class AgedItem extends NormalUpdatableItem {
    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality(1);
    }

    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }

    @Override
    public void handleExpired() {
        if (sellIn < 0) {
            increaseQuality(1);
        }
    }
}
