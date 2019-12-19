package com.company;

abstract public class AbstractQueue implements Queue {

    protected int size;
    protected int head;
    protected int tail;

    abstract public void enqueue(Object element);
    abstract public Object element();
    abstract public Object dequeue();
    abstract public void clear();
    abstract public int size();
    abstract public boolean isEmpty();

}