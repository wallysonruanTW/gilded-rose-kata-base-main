package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.sellIn < 11) {
                                item.quality = item.quality + 1;
                            }
                            if (item.sellIn < 6) {
                                item.quality = item.quality + 1;
                            }
                        }
                    } else {
                        item.quality = 50;
                    }
                }
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                    } else {
                        if (item.name.equals("Aged Brie") && item.quality < 50) {
                            item.quality = item.quality + 1;
                        } else {
                            if (item.quality > 0) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
