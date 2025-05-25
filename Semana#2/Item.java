package com.gildedrose;

public class Item {

    private String itemName;
    private int itemSellIn;
    private int itemQuality;

    public Item(String itemName, int itemSellIn, int itemQuality) {
        setItemName(itemName);
        setSellIn(itemSellIn);
        setQuality(itemQuality);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty. Please enter a valid name.");
        }
        this.itemName = itemName;
    }

    public int getItemSellIn() {
        return itemSellIn;
    }

    public void setSellIn(int itemSellIn) {
        this.itemSellIn = itemSellIn;
    }

    public int getitemQuality() {
        return itemQuality;
    }

    public void setQuality(int itemQuality) {
        if (itemQuality < 0 || itemQuality > 50) {
            throw new IllegalArgumentException("Quality must be between 0 and 50. Please enter a valid quality.");
        }
        this.itemQuality = itemQuality;
    }


   @Override
   public String toString() {
        return "GildedRose: \n Item name: " + this.itemName + "\n Sell in:" + this.itemSellIn + "\n Quality:" + this.itemQuality;
    }
}
