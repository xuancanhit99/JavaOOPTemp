package com.company;

public class InternetOrdersManager implements OrdersManager{

    private Queue<Order> internetOrders = new Queue<>();

    public void add(Order order){
        internetOrders.enqueue(order);
    }

    public Order remove(){
        return internetOrders.dequeue();
    }

    public Order order(){
        return internetOrders.peek();
    }

    @Override
    public int itemsQuantity(String itemName) {
        DoubleLinkedList<Order> list = internetOrders.asDoubleLinkedList();
        int quantity = 0;
        for (int i = 0; i < list.size(); ++i) {
            quantity += list.getNext().itemQuantity(itemName);
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem menuItem) {
        DoubleLinkedList<Order> list = internetOrders.asDoubleLinkedList();
        int quantity = 0;
        for (int i = 0; i < list.size(); ++i) {
            quantity += list.getNext().itemQuantity(menuItem);
        }
        return quantity;
    }

    @Override
    public Order[] getOrders(){
        DoubleLinkedList<Order> list = internetOrders.asDoubleLinkedList();
        Order[] array = new Order[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            array[i] = list.getNext();
        }
        return array;
    }

    @Override
    public double ordersCostSummary(){
        DoubleLinkedList<Order> list = internetOrders.asDoubleLinkedList();
        int cost = 0;
        for (int i = 0; i < list.size(); ++i) {
            cost += list.getNext().costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return internetOrders.size();
    }
}