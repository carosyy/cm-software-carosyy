package com.gildedrose;

class GildedRose {
    private Item[] items;

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
        if (items[i].quality < 50) {
            items[i].quality++;
        }
        if (items[i].sellIn < 0 && items[i].quality < 50) {
            items[i].quality++;
        }
    }

    private void updateBackstagePass(Item item) {
        if (items[i].sellIn < 0) {
            items[i].quality = 0;
            return;
        } else {
            if (items[i].quality < 50) {
                items[i].quality++;
            }
            if (items[i].sellIn < 11 && items[i].quality < 50) {
                items[i].quality++;
             }
            if (items[i].sellIn < 6 && items[i].quality < 50) {
                items[i].quality++;
            }
        }
    }

    private void updateNormalItem(Item item) {
        if (items[i].quality > 0) {
            items[i].quality--;
        }
        if (items[i].sellIn < 0 && items[i].quality > 0) {
            items[i].quality--;
        }
    }
