package com.gildedrose;

import java.util.ArrayList;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private ArrayList<String> legendary = new ArrayList<>();
    private ArrayList<String> passesToConcert = new ArrayList<>();
    private ArrayList<String> betterAged = new ArrayList<>();

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;

        legendary.add("Sulfuras, Hand of Ragnaros");
        passesToConcert.add("Backstage passes to a TAFKAL80ETC concert");
        betterAged.add("Aged Brie");
    }

    public boolean isLegendary(){
        if (legendary.contains(this.name)){
            return true;
        }
        return false;
    }

    public boolean isPassToConcert(){
        if (passesToConcert.contains(this.name)){
            return true;
        }
        return false;
    }

    public boolean isBetterAged(){
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
