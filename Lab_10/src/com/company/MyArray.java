package com.company;

class MyArray<T> {

    private T[] array;

    MyArray(T[] arr) {
        array = arr.clone();
    }

    T get(int index) {
        return array[index];
    }
}