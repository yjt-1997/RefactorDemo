package gildedRose;

public class ItemHandlerStrategy {
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private final String AGED = "Aged Brie";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private AgedItemHandler agedItemHandler = new AgedItemHandler();
    private BackstageItemHandler backstageItemHandler = new BackstageItemHandler();
    private NormaItemHandler normaItemHandler = new NormaItemHandler();
    private SulfurasItemHandler sulfurasItemHandler = new SulfurasItemHandler();

    public void handle(Item item) {
        switch (item.name) {
            case AGED:
                agedItemHandler.update(item);
                break;
            case BACKSTAGE:
                backstageItemHandler.update(item);
                break;
            case SULFURAS:
                sulfurasItemHandler.update(item);
                break;
            default:
                normaItemHandler.update(item);
                break;
        }
    }
}
