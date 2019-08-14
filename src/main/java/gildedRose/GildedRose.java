package gildedRose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updateQualityAndSellIn(item);
        }
    }

    private void updateQualityAndSellIn(Item item) {
        String itemName = item.name;
        if (itemName.equals("Aged Brie")) {
            new AgedBrieStrategy().updateQuality(item);
            return;
        }

        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            new BackstageStrategy().updateQuality(item);
            return;
        }

        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            new SulfurasStrategy().updateQuality(item);
            return;
        }
        new OtherItemStrategy().updateQuality(item);
    }
}