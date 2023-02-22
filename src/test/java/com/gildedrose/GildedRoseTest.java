package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void regularItemShouldDegradedItsQualityAfterOneDay() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(9, items[0].getSellIn());
        assertEquals(19, items[0].getQuality());
    }

    @Test
    public void regularItemShouldDegradeItsQualityTwiceAsFastWhenSellInDateHasPassed() {
        Item item = new Item("+5 Dexterity Vest", 0, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(-1, items[0].getSellIn());
        assertEquals(18, items[0].getQuality());
    }

    @Test
    public void qualityOfAnItemShouldNeverBeNegative() {
        Item item = new Item("+5 Dexterity Vest", 0, 0);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(-1, items[0].getSellIn());
        assertEquals(0, items[0].getQuality());
    }

    @Test
    public void agedBrieShouldIncreasItsQualityAfterOneDay() {
        Item item = new Item("Aged Brie", 2, 10);
        Item[] items = new Item[]{item};

        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(1, items[0].getSellIn());
        assertEquals(11, items[0].getQuality());
    }

    @Test
    public void agedBrieShouldIncreaseQualityBy2IfItHasExpired() {
        Item item = new Item("Aged Brie", 0, 10);
        Item[] items = new Item[]{item};

        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(-1, items[0].getSellIn());
        assertEquals(12, items[0].getQuality());
    }

    @Test
    public void qualityOfAnItemShouldNotIncreaseMoreThan50() {
        Item item = new Item("Aged Brie", 2, 50);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(1, items[0].getSellIn());
        assertEquals(50, items[0].getQuality());
    }

    @Test
    public void qualityOfAnItemShouldNotBeMoreThan50() {
        Item item = new Item("Aged Brie", 2, 89);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(1, items[0].getSellIn());
        assertEquals(50, items[0].getQuality());
    }

    @Test
    public void qualityOfABackstagePassesItemShouldNotBeMoreThan50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 89);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(1, items[0].getSellIn());
        assertEquals(50, items[0].getQuality());
    }

    @Test
    public void sulfurasShouldNeverDecreaseItsQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item[] items = new Item[]{item};

        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(0, items[0].getSellIn());
        assertEquals(80, items[0].getQuality());
    }

    @Test
    public void backstagePassesShouldIncreasItsQualityBy1WhenMoreThan10daysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(10, items[0].getSellIn());
        assertEquals(21, items[0].getQuality());
    }

    @Test
    public void backstagePassesShouldIncreasItsQualityBy2When10daysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(9, items[0].getSellIn());
        assertEquals(22, items[0].getQuality());
    }

    @Test
    public void backstagePassesShouldIncreaseItsQualityBy2WhenLessThan10daysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(8, items[0].getSellIn());
        assertEquals(22, items[0].getQuality());
    }

    @Test
    public void backstagePassesShouldIncreasesItsQualityBy3When5daysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(4, items[0].getSellIn());
        assertEquals(23, items[0].getQuality());
    }

    @Test
    public void backstagePassesShouldDropTheirQualityToZeroWhenArrivedSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(-1, items[0].getSellIn());
        assertEquals(0, items[0].getQuality());
    }

    @Disabled
    @Test
    public void conjuredItemsShouldIncreaseItsQualityBy2AfterOneDay() {
        Item item = new Item("Conjured Mana Cake", 3, 6);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);

        app.updateQualityOfAllItems();

        assertEquals(2, items[0].getSellIn());
        assertEquals(4, items[0].getQuality());
    }
}
