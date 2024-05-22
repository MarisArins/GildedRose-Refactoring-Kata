package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            NormalUpdatableItem updatableItem = (NormalUpdatableItem)item;
            updatableItem.updateQuality();
            updatableItem.updateSellIn();
            updatableItem.handleExpired();
        }
    }
}
