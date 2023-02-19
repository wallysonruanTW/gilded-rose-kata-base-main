package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            }else{
                if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                    if (item.sellIn > 5 && item.sellIn <= 10) {
                        item.quality += 2;
                    }
                    if (item.sellIn == 5) {
                        item.quality += 3;
                    }
                    if (item.sellIn > 10) {
                        item.quality += 1;
                    }
                    if (item.quality > 50) {
                        item.quality = 50;
                    }
                    if (item.sellIn == 0) {
                        item.quality = 0;
                    }

                    item.sellIn -= 1;
                }else{
                    if (!item.name.equals("Aged Brie")) {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        } else {
                            item.quality = 50;
                        }
                    }
                    item.sellIn = item.sellIn - 1;
                    if (item.sellIn < 0) {
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
