package gildedRose;

public class BackstageItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        item.subSellIn();
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        if (item.quality < 50) {
            item.addQuality();
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.addQuality();
                }
            }
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.addQuality();
                }
            }
        }
    }
}
