package gildedRose;

public class BackstageItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        item.subSellIn();
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        addQualityByQualityAndSellIn(item);
    }


    public void addQualityByQualityAndSellIn(Item item) {
        if (item.quality >= 50) {
            return;
        }
        if (item.quality <= 48 && item.sellIn < 6) {
            item.addQuality(3);
        } else if (item.quality <= 49 && isSellInIsIn6And11(item)) {
            item.addQuality(2);
        } else {
            item.addQuality();
        }
    }

    public boolean isSellInIsIn6And11(Item item) {
        return item.sellIn >= 6 && item.sellIn < 11;
    }

}
