package com.company;

public class TableOrdersManager implements OrdersManager{

    private Order[] orders;

    TableOrdersManager(int numberOfTables){
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

    void addItem(MenuItem item, int tableNumber){
        orders[tableNumber - 1].add(item);
    }

    int freeTableNumber(){
        for (int i = 0; i < orders.length; ++i) {
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
        for (int i = 0; i < orders.length; ++i) {
            if (orders[i] == null){
                freeTables[index] = i + 1;
                index++;
            }
        }
        return freeTables;
    }

    Order getOrder(int tableNumber){
        return orders[tableNumber - 1];
    }

    void remove(int tableNumber){
        orders[tableNumber - 1] = null;
    }

    boolean remove(Order order){
        for (int i = 0; i < orders.length; ++i) {
            if (orders[i].equals(order)){
                orders[i] = null;
                return true;
            }
        }
        return false;
    }

    int removeAll(Order order){
        int quantityDeleted = 0;
        for (int i = 0; i < orders.length; ++i) {
            if (orders[i].equals(order)){
                orders[i] = null;
                quantityDeleted++;
            }
        }
        return quantityDeleted;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int quantity = 0;
        for (Order order : orders){
            quantity += order.itemQuantity(itemName);
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem menuItem) {
        int quantity = 0;
        for (Order order : orders){
            quantity += order.itemQuantity(menuItem);
        }
        return quantity;
    }

    @Override
    public Order[] getOrders(){
        return orders.clone();
    }

    @Override
    public double ordersCostSummary(){
        int cost = 0;
        for (Order order : orders){
            if (order != null) {
                cost += order.costTotal();
            }
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return orders.length;
    }
}