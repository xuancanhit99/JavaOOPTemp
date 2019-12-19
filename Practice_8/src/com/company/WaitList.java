package com.company;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

class WaitList<E> implements IWaitList<E>{

    /** Content of WaitList */
    protected ConcurrentLinkedQueue<E> content = new ConcurrentLinkedQueue<>();

    /** Default constructor */
    WaitList(){}

    /**
     * Constructor with collection for WaitList content
     * @param c collection for adding in WaitList
     */
    WaitList(Collection<E> c){
        content.addAll(c);
    }

    /** @see Object#toString() */
    @Override
    public String toString() {
        return content.toString();
    }

    /** @see IWaitList#add */
    @Override
    public void add(E element) {
        content.add(element);
    }

    /** @see IWaitList#remove */
    @Override
    public E remove() {
        return content.remove();
    }

    /** @see IWaitList#contains */
    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    /** @see IWaitList#containsAll */
    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    /** @see IWaitList#isEmpty */
    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}