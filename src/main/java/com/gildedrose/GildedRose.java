package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.isRegular(item.name)){

                item.sellIn -= 1;

                if (item.quality > 50){
                    item.quality = 50;
                }
                if (item.sellIn < 0){
                    item.quality -= 1;
                }

                item.quality -= 1;

                if (item.quality < 0){
                    item.quality = 0;
                }
            }
            if(item.isPassToConcert(item.name)){
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
            }
            if (item.isBetterAged(item.name)){
                item.sellIn -= 1;
                if (item.sellIn < 0){
                    item.quality += 2;
                }else{
                    item.quality += 1;
                }
                if (item.quality > 50){
                    item.quality = 50;
                }
            }
        }
    }
}
