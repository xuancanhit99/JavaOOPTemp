package com.company;

public interface Order {
    boolean add(Item item);
    boolean remove(String name);
    int removeAll(String name);
    int itemsCount();
    int itemCount(String name);
    Item[] getItems();
    double costTotal();
    String[] itemsNames();
    Item[] sortedItemsByCostDesc();
}
