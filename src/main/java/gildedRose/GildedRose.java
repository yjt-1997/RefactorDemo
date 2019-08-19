package gildedRose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAged(items[i])
                    && !isBackstage(items[i])) {
                if (items[i].quality > 0) {
                    if (!isSulfuras(items[i])) {
                        items[i].subQuality();
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].addQuality();

                    if (isBackstage(items[i])) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].addQuality();
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].addQuality();
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(items[i])) {
                items[i].subSellIn();
            }

            if (items[i].sellIn < 0) {
                if (!isAged(items[i])) {
                    if (!isBackstage(items[i])) {
                        if (items[i].quality > 0) {
                            if (!isSulfuras(items[i])) {
                                items[i].subQuality();
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].addQuality();
                    }
                }
            }
        }
    }

    private boolean isAged(Item item) {
        return item.name.equals(ItemName.Aged.getName());
    }

    private boolean isBackstage(Item item) {
        return item.name.equals(ItemName.Backstage.getName());
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(ItemName.Sulfuras.getName());
    }
}
