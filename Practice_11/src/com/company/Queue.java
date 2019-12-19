package com.company;

public interface Queue {
    //pre: element != null
    //post: size = size + 1,
    //      element inserted at the end of queue
    void enqueue(Object element);

    //pre: size > 0
    //post: R = first element in queue;
    Object element();

    //pre: size > 0;
    //post: size = size - 1,
    //      first element of queue deleted
    Object dequeue();

    //post: R = size
    int size();

    //post: R = (size == 0)
    boolean isEmpty();

    //post: size = 0
    //      delete all queue elements
    void clear();
}