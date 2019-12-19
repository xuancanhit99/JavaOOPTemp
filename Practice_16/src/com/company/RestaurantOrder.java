package com.company;

public class RestaurantOrder implements Order {

    private Item[] items;

    RestaurantOrder(){
        items = new Item[0];
    }

    RestaurantOrder(Item[] items){
        this.items = items.clone();
    }

    @Override
    public boolean add(Item item) {
        Item[] newItems = new Item[items.length + 1];
        newItems[0] = item;
        System.arraycopy(items, 0, newItems, 1, items.length);
        items = newItems.clone();
        return true;
    }

    @Override
    public boolean remove(String name) {
        boolean isDeleted = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(name)){
                items[i] = null;
                isDeleted = true;
                break;
            }
        }
        if (isDeleted){
            Item[] newItems = new Item[items.length - 1];
            int index = 0;
            for (Item item : items){
                if (item != null){
                    newItems[index] = item;
                    index++;
                }
            }
            items = newItems.clone();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int removeAll(String name) {
        int quantityOfDeleted = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(name)){
                items[i] = null;
                quantityOfDeleted++;
            }
        }
        if (quantityOfDeleted > 0){
            Item[] newItems = new Item[items.length - quantityOfDeleted];
            int index = 0;
            for (Item item : items){
                if (item != null){
                    newItems[index] = item;
                    index++;
                }
            }
            items = newItems.clone();
            return quantityOfDeleted;
        } else {
            return quantityOfDeleted;
        }
    }

    @Override
    public int itemsCount() {
        return items.length;
    }

    @Override
    public int itemCount(String name) {
        int quantity = 0;
        for (Item item : items){
            if (item.getName().equals(name)){
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public Item[] getItems() {
        return items.clone();
    }

    @Override
    public double costTotal() {
        int costTotal = 0;
        for (Item item : items){
            costTotal += item.getCost();
        }
        return costTotal;
    }

    @Override
    public String[] itemsNames() {
        String[] itemsNames = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            itemsNames[i] = items[i].getName();
        }
        return itemsNames.clone();
    }

    @Override
    public Item[] sortedItemsByCostDesc() {
        Item[] itemsList = items.clone();
        if (itemsList.length != 1){
            Item temp;
            for (int i = 1; i < itemsList.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (itemsList[j].getCost() > itemsList[j - 1].getCost()) {
                        temp = itemsList[j];
                        itemsList[j] = itemsList[j - 1];
                        itemsList[j - 1] = temp;
                    }
                }
            }
        }
        return itemsList.clone();
    }
}