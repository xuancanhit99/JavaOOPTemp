package com.company;

public class InternetOrder implements Order {

    private DoubleLinkedList<Item> items = new DoubleLinkedList<>();

    public InternetOrder(){}

    public InternetOrder(Item[] items){
        for(Item item : items){
            this.items.addNode(item);
        }
    }

    @Override
    public boolean add(Item item) {
        items.addNode(item);
        return true;
    }

    @Override
    public boolean remove(String name) {
        Item[] list = getItems();
        for(Item item : list){
            if (item.getName().equals(name)){
                items.removeNode(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String name) {
        int count = 0;
        while(remove(name)){
            count++;
        }
        return count;
    }

    @Override
    public int itemsCount() {
        return items.size();
    }

    @Override
    public int itemCount(String name) {
        int count = 0;
        for (int i = 0; i < items.size(); ++i) {
            if (items.getNext().getName().equals(name)){
                count++;
            }
        }
        return count;
    }

    @Override
    public Item[] getItems() {
        Item[] list = new Item[items.size()];
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
    public Item[] sortedItemsByCostDesc() {
        Item[] list = getItems();
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j].getCost() < list[j + 1].getCost()) {
                    Item tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
        return list.clone();
    }
}
