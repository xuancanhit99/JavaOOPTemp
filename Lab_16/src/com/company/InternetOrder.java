package com.company;

public class InternetOrder implements Order {

    private DoubleLinkedList<MenuItem> items = new DoubleLinkedList<>();
    private Customer customer;

    public InternetOrder(){}

    public InternetOrder(MenuItem[] items){
        for(MenuItem item : items){
            this.items.addNode(item);
        }
    }

    @Override
    public boolean add(MenuItem item) {
        items.addNode(item);
        return true;
    }

    @Override
    public boolean remove(String itemName) {
        MenuItem[] list = getItems();
        for(MenuItem item : list){
            if (item.getName().equals(itemName)){
                items.removeNode(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem menuItem) {
        MenuItem[] list = getItems();
        for(MenuItem item : list){
            if (item.equals(menuItem)){
                items.removeNode(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while(remove(itemName)){
            count++;
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem menuItem) {
        int count = 0;
        while(remove(menuItem)){
            count++;
        }
        return count;
    }

    @Override
    public int itemsQuantity() {
        return items.size();
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < items.size(); ++i) {
            if (items.getNext().getName().equals(itemName)){
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem menuItem) {
        int count = 0;
        for (int i = 0; i < items.size(); ++i) {
            if (items.getNext().equals(menuItem)){
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] list = new MenuItem[items.size()];
        for (int i = 0; i < items.size(); ++i) {
            list[i] = items.getNext();
        }
        return list.clone();
    }

    @Override
    public double costTotal() {
        double cost = 0;
        for (int i = 0; i < items.size(); ++i) {
            cost += items.getNext().getCost();
        }
        return cost;
    }

    @Override
    public String[] itemsNames() {
        String[] list = new String[items.size()];
        for (int i = 0; i < items.size(); ++i) {
            list[i] = items.getNext().getName();
        }
        return list.clone();
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] list = getItems();
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

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
