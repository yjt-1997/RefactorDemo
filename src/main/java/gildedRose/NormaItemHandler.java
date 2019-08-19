package gildedRose;

public class NormaItemHandler {
    public void update(Item item) {
        if (item.quality > 0) {
            item.subQuality();
        }
        item.subSellIn();
        if (item.sellIn < 0) {
            item.subQuality();
        }
    }
}
