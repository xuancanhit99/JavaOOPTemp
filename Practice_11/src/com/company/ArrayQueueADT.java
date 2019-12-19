package com.company;

public class ArrayQueueADT
{
    private int size;
    private int head;
    private int tail;
    private Object[] elements;

    public ArrayQueueADT(int capacity) {
        elements = new Object[capacity];
    }

    //pre: element != null,
    //     queue != null
    //post: elements[tail] = element,
    //      tail = (tail + 1) % elements.length,
    //      size = size + 1
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert queue != null;
        assert element != null;
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }

    //pre: queue != null,
    //     size > 0
    //post: R = elements[head]
    public static Object element(ArrayQueueADT queue) {
        assert queue != null;
        assert queue.size > 0;
        return queue.elements[queue.head];
    }

    //pre: queue != null,
    //     size > 0
    //post: R = elements[head],
    //      head = (head + 1) % elements.length,
    //      size = size - 1
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue != null;
        Object tmp = element(queue);
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return tmp;
    }

    //pre: queue != null
    //post: R = size
    public static int size(ArrayQueueADT queue) {
        assert queue != null;
        return queue.size;
    }

    //pre: queue != null
    //post: R = (size == 0)
    public static boolean isEmpty(ArrayQueueADT queue) {
        assert queue != null;
        return (queue.size == 0);
    }

    //pre: queue != null
    //post: size = 0,
    //      head = 0,
    //      tail = 0
    public static void clear(ArrayQueueADT queue) {
        assert queue != null;
        queue.head = 0;
        queue.tail = 0;
        queue.size = 0;
    }
}