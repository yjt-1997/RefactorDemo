package gildedRose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemHandlerStrategy itemHandlerStrategy = new ItemHandlerStrategy();
        for (int i = 0; i < items.length; i++) {
            itemHandlerStrategy.handle(items[i]);
        }
    }
}
