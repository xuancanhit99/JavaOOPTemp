package com.company;

class MyArrayList<T> {

    private final int startSize = 1;
    private Object[] array = new Object[startSize];
    private int pointer = 0;

    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length+1);
        array[pointer++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void delete(int index) {
        for (int i = index; i < pointer; ++i)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > startSize)
            resize(array.length-1);
    }

    public int getSize() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(45);
        list.add(50);
        list.add(100);

        for (int i = 0; i < list.getSize(); ++i)
            System.out.print(list.get(i) + " ");
        System.out.println();

        list.delete(1);
        for (int i = 0; i < list.getSize(); ++i)
            System.out.print(list.get(i) + " ");
        System.out.println();

        list.add(200);
        for (int i = 0; i < list.getSize(); ++i)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
