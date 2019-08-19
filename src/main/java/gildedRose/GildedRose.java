package gildedRose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Test":
                    new NormaItemHandler().update(items[i]);
                    break;
                default:
                    updateItem(items[i]);
            }

        }
    }

    private void updateItem(Item item) {
        if (!isAged(item) && !isBackstage(item)) {
            if (item.quality > 0) {
                if (!isSulfuras(item)) {
                    item.subQuality();
                }
            }
        } else {
            if (item.quality < 50) {
                item.addQuality();

                if (isBackstage(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.addQuality();
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.addQuality();
                        }
                    }
                }
            }
        }

        if (!isSulfuras(item)) {
            item.subSellIn();
        }

        if (item.sellIn < 0) {
            if (!isAged(item)) {
                if (!isBackstage(item)) {
                    if (item.quality > 0) {
                        if (!isSulfuras(item)) {
                            item.subQuality();
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.addQuality();
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
