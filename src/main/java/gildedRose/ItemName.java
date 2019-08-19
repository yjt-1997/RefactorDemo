package gildedRose;

public enum ItemName {

    Aged("Aged Brie"),
    Backstage("Backstage passes to a TAFKAL80ETC concert"),
    Sulfuras("Sulfuras, Hand of Ragnaros");

    private String name;

    ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
