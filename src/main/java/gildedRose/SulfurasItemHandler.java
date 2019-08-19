package gildedRose;

public class SulfurasItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.subQuality();
        }
    }
}
