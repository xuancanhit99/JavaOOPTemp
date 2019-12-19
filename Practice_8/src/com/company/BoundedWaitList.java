package com.company;

/**
 * WaitList class with bounds
 * @author Vladimir Zhuravlev
 * @param <E> - type of data used in list
 * @version 1.0
 */
class BoundedWaitList<E> extends WaitList<E> {

    /** Capacity of WaitList */
    private int capacity;

    /**
     * Constructor with list capacity
     * @param capacity - capacity of list
     */
    BoundedWaitList(int capacity){
        this.capacity = capacity;
    }

    /**
     * Method returns capacity of list
     * @return capacity of WaitList
     */
    int getCapacity(){
        return capacity;
    }

    /**
     * Method adds a new item to list
     * @param element - new element for list
     * @throws RuntimeException - not enough capacity for adding new item
     * @see IWaitList#add
     */
    @Override
    public void add(E element) throws RuntimeException{
        if (content.size() < capacity){
            super.add(element);
        } else {
            throw new RuntimeException("not enough capacity for adding new item");
        }
    }

    /** @see Object#toString() */
    @Override
    public String toString() {
        return super.toString() + " Capacity = " + getCapacity();
    }
}