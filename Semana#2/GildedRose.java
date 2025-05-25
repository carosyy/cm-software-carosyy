package com.gildedrose;

class GildedRose {
    private Item[] items;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getItemName()) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    updateNormalItem(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        lowerSellIn(item);
        if (item.getItemQuality() < MAX_QUALITY) {
            increaseQuality(item);
        }
        if (item.getItemSellIn() < MIN_QUALITY) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        lowerSellIn(item);
        if (item.getItemSellIn() < MIN_QUALITY) {
            setItemQuality(item, 0);
            return;
        } 
        if (item.getItemQuality() < MAX_QUALITY) {
            increaseQuality(item);
            if (item.getItemSellIn() < 10) {
                increaseQuality(item);
            }
            if (item.getItemSellIn() < 5) {
                increaseQuality(item);
            }
        }
    }

    private void updateNormalItem(Item item) {
        lowerSellIn(item);
        if (item.getItemQuality() > MIN_QUALITY) {
            decreaseQuality(item);
        }
        if (item.getItemSellIn() < MIN_QUALITY) {
            decreaseQuality(item);
        }
    }

    private void lowerSellIn(Item item) {
        item.setItemSellIn(item.getItemSellIn() - 1);
    }
        
    private void increaseQuality(Item item) {
        if (item.getItemQuality() < MAX_QUALITY) {
            item.setItemQuality(item.getItemQuality() + 1);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.getItemQuality() > MIN_QUALITY) {
            item.setItemQuality(item.getItemQuality() - 1);
        }
    }

    private void setItemQuality(Item item, int qualityValue) {
        item.setItemQuality(qualityValue);
    }
