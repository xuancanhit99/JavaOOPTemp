package com.company;

public class DoubleLinkedList<T> {

    private class Node{
        T data;
        Node previous;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head = null;
    private int size = 0;

    public void addNode(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.previous = head;
            head.next = head;
        } else {
            head.next = newNode;
            newNode.previous = head;

            Node firstNode = head;
            while(firstNode.previous != head){
                firstNode = firstNode.previous;
            }
            firstNode.previous = newNode;
            newNode.next = firstNode;
        }
        size++;
    }

    public boolean removeNode(T data){
        Node startNode = head;
        while(head.previous != startNode){
            if (head.data == data){
                if (head.next == head){
                    head = null;
                } else {
                    head.previous.next = head.next;
                    head.next.previous = head.previous;
                    head = head.next;
                }
                size--;
                return true;
            }
            head = head.previous;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public T getNext() {
        head = head.next;
        return head.data;
    }
}