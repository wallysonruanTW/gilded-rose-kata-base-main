package com.gildedrose;

import java.util.ArrayList;

public class Item {

    private String name;
    private int sellIn;
    private int quality;
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void decreaseSellInBy1(){
        this.sellIn -= 1;
    }

    public void decreaseQualityBy(int total){
        this.quality -= total;
    }

    public void increaseQualityBy(int total){
        this.quality += total;
    }

    public boolean isLegendary(){
        ArrayList<String> legendary = new ArrayList<>();
        legendary.add("Sulfuras, Hand of Ragnaros");

        if (legendary.contains(this.name)){
            return true;
        }
        return false;
    }

    public boolean isPassToConcert(){
        ArrayList<String> passesToConcert = new ArrayList<>();
        passesToConcert.add("Backstage passes to a TAFKAL80ETC concert");

        if (passesToConcert.contains(this.name)){
            return true;
        }
        return false;
    }

    public boolean isBetterAged(){
        ArrayList<String> betterAged = new ArrayList<>();
        betterAged.add("Aged Brie");

        if (betterAged.contains(this.name)){
            return true;
        }
        return false;
    }

    public boolean isRegular(){
        if (isBetterAged() || isLegendary() || isPassToConcert()){
            return false;
        }
        return true;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
