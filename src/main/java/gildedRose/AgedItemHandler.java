package gildedRose;

public class AgedItemHandler implements ItemHandler {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.addQuality();
        }
        item.subSellIn();
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.addQuality();
            }
        }
    }
}
