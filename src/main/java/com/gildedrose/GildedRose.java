package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityOfAllItems() {
        for (Item item : items) {
            item.upgradeQuality();
        }
    }
}
