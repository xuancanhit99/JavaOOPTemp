package com.company;

public class Queue<T> {
    class Node {
        T data;
        Node previous = null;
        Node next     = null;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = tail;
            tail.previous = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        } else {
            T removed = head.data;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.previous;
                head.next = null;
            }
            size--;
            return removed;
        }
    }

    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return head.data;
        }
    }

    public int size() {
        return size;
    }

    public DoubleLinkedList<T> asDoubleLinkedList() {
        DoubleLinkedList<T> list = new DoubleLinkedList<>();
        Node tmp = head;
        for (int i = 0; i < size; ++i) {
            list.addNode(tmp.data);
            tmp = tmp.previous;
        }
        return list;
    }
}
