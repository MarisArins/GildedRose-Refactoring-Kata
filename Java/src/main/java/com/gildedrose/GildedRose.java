package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        Arrays.stream(items)
            .map(RegularItem.class::cast)
            .forEach(RegularItem::updateItem);
    }
}
