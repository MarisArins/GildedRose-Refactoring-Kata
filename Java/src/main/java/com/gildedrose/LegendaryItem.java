package com.gildedrose;

class LegendaryItem extends RegularItem {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        // LegendaryItem does not change
    }
}
