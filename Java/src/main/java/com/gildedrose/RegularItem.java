package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

class RegularItem extends Item {

    public static final int QUALITY_MIN = 0;
    public static final int QUALITY_MAX = 50;

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        updateQuality();
        updateSellIn();
        if (sellIn < 0) {
            handleExpired();
        }
    }

    protected void updateQuality() {
        updateQuality(-1);
    }

    protected final void updateQuality(int increment) {
        quality = max(QUALITY_MIN, min(QUALITY_MAX, quality + increment));
    }

    protected void updateSellIn() {
        updateSellIn(-1);
    }

    protected final void updateSellIn(int increment) {
        sellIn = (int) max(Integer.MIN_VALUE, min(Integer.MAX_VALUE, ((long) sellIn) + increment));
    }

    protected void handleExpired() {
        updateQuality(-1);
    }
}
