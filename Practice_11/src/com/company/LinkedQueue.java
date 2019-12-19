package com.company;

import java.util.LinkedList;

public class LinkedQueue
{
    private int size;
    private int head;
    private int tail;
    private int capacity;
    private LinkedList<Object> elements = new LinkedList<>();

    //pre: capacity > 0
    //post: this.capacity = capacity
    public LinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    //pre: element != null
    //post: elements[tail] = element,
    //      tail = (tail + 1) % capacity,
    //      size = size + 1
    public void enqueue(Object element) {
        assert element != null;
        elements.add(element);
        tail = (tail + 1) % capacity;
        size++;
    }

    //pre: size > 0
    //post: R = elements[head]
    public Object element() {
        assert size > 0;
        return elements.get(head);
    }

    //pre: size > 0
    //post: R = elements[head],
    //      head = (head + 1) % capacity,
    //      size = size - 1
    public Object dequeue() {
        assert size > 0;
        Object tmp = element();
        elements.set(head, null);
        head = (head + 1) % capacity;
        size--;
        return tmp;
    }

    //post: R = size
    public int size() {
        return size;
    }

    //post: R = (size == 0)
    public boolean isEmpty() {
        return (size == 0);
    }

    //post: size = 0,
    //      head = 0,
    //      tail = 0,
    public void clear() {
        head = 0;
        tail = 0;
        size = 0;
    }
}