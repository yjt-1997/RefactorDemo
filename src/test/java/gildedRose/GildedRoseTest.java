package gildedRose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void should_decrease_one_when_given_name_Test_and_quality_50() {
        Item item = new Item("Test", 50, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), "Test, 49, 49");
    }

    @Test
    public void should_increase_one_quality_decrease_quality_when_given_name_Backstage_and_quality_48_sellIn_10() {
        Item item = new Item(ItemName.Backstage, 10, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), ItemName.Backstage + ", 9, 50");
    }

    @Test
    public void should_decrease_one_when_given_name_Backstage_and_quality_45_sellIn_4() {
        Item item = new Item(ItemName.Backstage, 4, 45);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), ItemName.Backstage + ", 3, 48");
    }

    @Test
    public void should_decrease_one_when_given_name_Test_and_quality_49_lessThan_0() {
        Item item = new Item("Test", 49, -1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), "Test, 48, -1");
    }

    @Test
    public void should_decrease_one_when_given_name_Backstage_and_quality_49_lessThan_0() {
        Item item = new Item(ItemName.Backstage, 49, -1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), ItemName.Backstage + ", 48, 0");
    }

    @Test
    public void should_increase_one_quality_decrease_quality_when_given_name_Aged_and_quality_49_sellIn_lessThan_0() {
        Item item = new Item(ItemName.Aged, -1, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), ItemName.Aged + ", -2, 50");
    }

    @Test
    public void should_decrease_one_sellIn_and_quality_when_given_name_Test_and_quality_50_and_sellIn_lessThan_0() {
        Item item = new Item("Test", -1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), "Test, -2, 48");
    }

    @Test
    public void should_decrease_one_sellIn_and_quality_when_given_name_Test_and_quality_49_and_sellIn_lessThan_0() {
        Item item = new Item("Test", -1, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), "Test, -2, 47");
    }

    @Test
    public void should_decrease_one_sellIn_and_quality_when_given_name_Backstage_sellIn_lessThan_0() {
        Item item = new Item(ItemName.Backstage, -1, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), ItemName.Backstage + ", -2, 0");
    }

    @Test
    public void should_one_sellIn_and_quality_when_given_name_Aged_sellIn_lessThan_0() {
        Item item = new Item(ItemName.Aged, -1, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].toString(), ItemName.Aged + ", -2, 42");
    }
}
