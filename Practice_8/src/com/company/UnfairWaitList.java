package com.company;

/**
 * UnfairWaitList class
 * @author Vladimir Zhuravlev
 * @param <E> - type of data used in list
 * @version 1.0
 */
class UnfairWaitList<E> extends WaitList<E> {

    /** Default constructor */
    UnfairWaitList(){}

    /**
     * Method for removing the item from list
     * @param element - item for removing
     */
    void remove(E element){
        content.remove(element);
    }

    /**
     * Method for moving item to the end
     * @param element item for moving
     */
    void moveToBack(E element){
        remove(element);
        super.add(element);
    }
}