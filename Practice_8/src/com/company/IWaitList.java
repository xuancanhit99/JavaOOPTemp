package com.company;

import java.util.Collection;

/**
 * Interface for WaitList
 * @author Vladimir Zhuravlev
 * @param <E> - type of data used in list
 * @version 1.0
 */
interface IWaitList<E> {

    /**
     * Method adds a new item
     * @param element - new item
     */
    void add(E element);

    /**
     * Method removes the last item in list
     * @return removed element
     */
    E remove();

    /**
     * Method checks is WaitList contains item
     * @param element - item for search
     * @return result of finding
     */
    boolean contains(E element);

    /**
     * Method checks is WaitList contains collection
     * @param c - collection for search
     * @return result of finding
     */
    boolean containsAll(Collection<E> c);

    /**
     * Method for check is WaitList is empty
     * @return result
     */
    boolean isEmpty();
}