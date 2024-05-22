package com.gildedrose;

class NormalUpdatableItem extends Item {
    public NormalUpdatableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        decreaseQuality(1);
    }

    public void updateSellIn() {
        sellIn -= 1;
    }

    public void handleExpired() {
        if (sellIn < 0) {
            decreaseQuality(1);
        }
    }

    protected void increaseQuality(int amount) {
        this.quality = Math.min(50, this.quality + amount);
    }

    protected void decreaseQuality(int amount) {
        this.quality = Math.max(0, this.quality - amount);
    }
}
