package com.company;

public interface SearchAndSort {
    void sort();
    Student search(String name) throws StudentNotFoundException;
}
