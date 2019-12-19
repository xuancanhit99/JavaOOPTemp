package com.company;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[10];

        for (int i = 0; i < 10; ++i) {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < 10; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
