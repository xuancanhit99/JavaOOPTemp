package com.company;

import java.util.HashMap;

public class OrderManager {

    private Order[] orders;
    private HashMap<String, Order> internetOrders;

    OrderManager(int numberOfTables){
        this.orders = new Order[numberOfTables];
    }

    void add(Order order, int tableNumber) throws IllegalTableNumber, OrderAlreadyAddedException {
        if (tableNumber - 1 >= orders.length){
            throw new IllegalTableNumber(tableNumber);
        } else {
            if (orders[tableNumber - 1] != null){
                throw new OrderAlreadyAddedException();
            } else {
                orders[tableNumber - 1] = order;
            }
        }
    }

    void add(Order order, String address){
        internetOrders.put(address, order);
    }

    Order getOrder(int tableNumber){
        return orders[tableNumber - 1];
    }

    Order getOrder(String address){
        return internetOrders.get(address);
    }

    void addItem(Item item, int tableNumber){
        orders[tableNumber - 1].add(item);
    }

    void addItem(Item item, String address){
        internetOrders.get(address).add(item);
    }

    void removeOrder(int tableNumber){
        orders[tableNumber - 1] = null;
    }

    void removeOrder(String address){
        internetOrders.remove(address);
    }

    int freeTableNumber(){
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null){
                return i + 1;
            }
        }
        return 0;
    }

    int[] freeTableNumbers(){
        int freeTablesCounter = 0;
        for (Order order : orders) {
            if (order == null) {
                freeTablesCounter++;
            }
        }

        int[] freeTables = new int[freeTablesCounter];
        int index = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null){
                freeTables[index] = i + 1;
                index++;
            }
        }
        return freeTables;
    }

    Order[] getOrders(){
        return orders.clone();
    }

    Order[] getInternetOrders(){
        Order[] ordersList = new Order[internetOrders.size()];
        int index = 0;
        for (String address : internetOrders.keySet()){
            ordersList[index] = internetOrders.get(address);
        }
        return ordersList;
    }

    double ordersCostSummary(){
        int cost = 0;
        for (Order order : orders){
            cost += order.costTotal();
        }
        return cost;
    }

    double internetOrdersCostSummary(){
        int cost = 0;
        for (Order order : getInternetOrders()){
            cost += order.costTotal();
        }
        return cost;
    }

    int itemQuantity(String itemName){
        int quantity = 0;
        for (Order order : orders){
            quantity += order.itemCount(itemName);
        }
        return quantity;
    }

    int internetItemQuantity(String itemName){
        int quantity = 0;
        for (Order order : getInternetOrders()){
            quantity += order.itemCount(itemName);
        }
        return quantity;
    }
}