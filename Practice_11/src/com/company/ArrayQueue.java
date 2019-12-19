package com.company;

public class ArrayQueue extends AbstractQueue{
//    private int size;
//    private int head;
//    private int tail;
    private Object[] elements;

    public ArrayQueue(int capacity) {
        elements = new Object[capacity];
    }

    //pre: element != null
    //post: elements[tail] = element,
    //      tail = (tail + 1) % elements.length,
    //      size = size + 1
    public void enqueue(Object element) {
        assert element != null;
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    //pre: size > 0
    //post: R = elements[head]
    public Object element() {
        assert size > 0;
        return elements[head];
    }

    //pre: size > 0
    //post: R = elements[head],
    //      head = (head + 1) % elements.length,
    //      size = size - 1
    public Object dequeue() {
        Object tmp = element();
        elements[head] = null;
        head = (head + 1) % elements.length;
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