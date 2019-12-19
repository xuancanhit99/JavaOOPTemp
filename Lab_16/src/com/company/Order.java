package com.company;

public interface Order {
    boolean add(MenuItem item);
    String[] itemsNames();
    int itemsQuantity();
    int itemQuantity(String itemName);
    int itemQuantity(MenuItem menuItem);
    MenuItem[] getItems();
    boolean remove(String itemName);
    boolean remove(MenuItem menuItem);
    int removeAll(String itemName);
    int removeAll(MenuItem menuItem);
    MenuItem[] sortedItemsByCostDesc();
    double costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);
}
