package com.company;

public class TableOrder implements Order {

    private Customer customer;
    private MenuItem[] items;

    TableOrder(){
        items = new MenuItem[0];
    }

    TableOrder(MenuItem[] items){
        this.items = items.clone();
    }

    @Override
    public boolean add(MenuItem item) {
        MenuItem[] newItems = new MenuItem[items.length + 1];
        newItems[0] = item;
        System.arraycopy(items, 0, newItems, 1, items.length);
        items = newItems.clone();
        return true;
    }

    @Override
    public boolean remove(String itemName) {
        boolean isDeleted = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)){
                items[i] = null;
                isDeleted = true;
                break;
            }
        }
        return removeItem(isDeleted);
    }

    @Override
    public boolean remove(MenuItem menuItem) {
        boolean isDeleted = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(menuItem)){
                items[i] = null;
                isDeleted = true;
                break;
            }
        }
        return removeItem(isDeleted);
    }

    private boolean removeItem(boolean isDeleted) {
        if (isDeleted){
            MenuItem[] newItems = new MenuItem[items.length - 1];
            int index = 0;
            for (MenuItem item : items){
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
    public int removeAll(String itemName) {
        int quantity = 0;
        while(remove(itemName)){
            quantity++;
        }
        return quantity;
    }

    @Override
    public int removeAll(MenuItem menuItem) {
        int quantity = 0;
        while(remove(menuItem)){
            quantity++;
        }
        return quantity;
    }

    @Override
    public int itemsQuantity() {
        return items.length;
    }

    @Override
    public int itemQuantity(String itemName) {
        int quantity = 0;
        for (MenuItem item : items){
            if (item.getName().equals(itemName)){
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public int itemQuantity(MenuItem menuItem) {
        int quantity = 0;
        for (MenuItem item : items){
            if (item.equals(menuItem)){
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public MenuItem[] getItems() {
        return items.clone();
    }

    @Override
    public double costTotal() {
        int costTotal = 0;
        for (MenuItem item : items){
            costTotal += item.getCost();
        }
        return costTotal;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] list = items.clone();
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j].getCost() < list[j + 1].getCost()) {
                    MenuItem tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
        return list.clone();
    }
}