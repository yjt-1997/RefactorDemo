package gildedRose;

import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {
    @Test
    public void should_decrease_sellIn_by_1_and_increase_quality_by_1_given_aged_brie_and_sellIn_greater_than_0_and_quality_smaller_than_50() {
        Item[] items = new Item[1];
        Item item = new Item("Aged Brie", 1, 10);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void should_decrease_sellIn_by_1_and_increase_quality_by_2_given_aged_brie_and_sellIn_is_0_and_quality_is_10() {
        Item[] items = new Item[1];
        Item item = new Item("Aged Brie", 0, 10);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    public void max_quality_is_50_for_aged_brie() {
        Item[] items = new Item[1];
        Item item = new Item("Aged Brie", 0, 50);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void should_not_alt_sellIn_and_not_alt_quality_given_sulfuras() {
        Item[] items = new Item[1];
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 20);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(1, item.sellIn);
        assertEquals(20, item.quality);
    }
    @Test
    public void should_decrease_sellIn_by_1_and_increase_quality_by_1_given_backstage_passes_and_sellIn_is_11_and_quality_smaller_than_50() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(41, item.quality);
    }

    @Test
    public void should_decrease_sellIn_by_1_and_increase_quality_by_2_given_backstage_passes_and_sellIn_is_10_and_quality_smaller_than_49() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void should_decrease_sellIn_by_1_and_increase_quality_by_3_given_backstage_passes_and_sellIn_smaller_than_6_and_quality_smaller_than_48() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void max_quality_is_50_for_backstage_passes() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void should_update_quality_as_0_given_backstage_passes_sellIn_is_0() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 47);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void should_decrease_sellIn_by_1_and_decrease_quality_by_1_given_otherItem_and_sellIn_is_1_and_quality_is_10() {
        Item[] items = new Item[1];
        Item item = new Item("Other Item", 1, 10);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(0, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    public void should_decrease_sellIn_by_1_and_decrease_quality_by_2_given_otherItem_and_sellIn_is_0_and_quality_is_10() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage", 0, 10);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    public void the_min_quality_is_0_for_other_item() {
        Item[] items = new Item[1];
        Item item = new Item("Backstage", -1, 1);
        items[0] = item;

        new GildedRose(items).updateQuality();

        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
}