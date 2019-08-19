package gildedRose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void addQuality() {
        this.quality++;
    }

    public void addQuality(int num) {
        this.quality += num;
    }

    public void subQuality() {
        this.quality--;
    }

    public void subSellIn() {
        this.sellIn--;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
