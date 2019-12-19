package com.company;

public class ArrayQueueModule {
    private static int size;
    private static int head;
    private static int tail;
    private static Object[] elements = new Object[10];

    //pre: element != null
    //post: elements[tail] = element,
    //      tail = (tail + 1) % elements.length,
    //      size = size + 1
    public static void enqueue(Object element) {
        assert element != null;
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    //pre: size > 0
    //post: R = elements[head]
    public static Object element() {
        assert size > 0;
        return elements[head];
    }

    //pre: size > 0
    //post: R = elements[head],
    //      head = (head + 1) % elements.length,
    //      size = size - 1
    public static Object dequeue() {
        assert size > 0;
        Object tmp = element();
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return tmp;
    }

    //post: R = size
    public static int size() {
        return size;
    }

    //post: R = (size == 0)
    public static boolean isEmpty() {
        return (size == 0);
    }

    //post: size = 0,
    //      head = 0,
    //      tail = 0
    public static void clear() {
        head = 0;
        tail = 0;
        size = 0;
    }
}