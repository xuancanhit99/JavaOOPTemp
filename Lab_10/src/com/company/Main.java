package com.company;

import org.omg.CORBA.INTERNAL;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1
        System.out.println("EX 1:");
        Integer[] arr = {1,2,3,4,5};
        {
            ArrayList<Integer> list = getList(arr);
            for (Integer i : list) {
                System.out.println(i);
            }
        }

        // 2 3
        System.out.println("\nEX 2, 3:");
        MyArray<Integer> myArray = new MyArray<>(arr);
        System.out.println("myArray[0] = " + myArray.get(0));

        // 4
        System.out.println("\nEX 4:");
        String path = "/Users/vladimir/Desktop/Programming/OOP Java/Labs/Lab_10";
        ArrayList<String> list = getListFromFile(new File(path));

        // 5
        ArrayList<Integer> arrayList = Solution.newArrayList(arr);
        HashSet<Integer> hashSet = Solution.newHashSet(arr);
        Solution.MapPair<Integer, String>[] hashMapArr = new Solution.MapPair[]{
                new Solution.MapPair<>(1, "a"),
                new Solution.MapPair<>(2, "b"),
                new Solution.MapPair<>(3, "c")
        };
        HashMap<Integer, String> hashMap = Solution.newHashMap(hashMapArr);
    }

    private static <T> ArrayList<T> getList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    private static ArrayList<String> getListFromFile(File file) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(file.list()));
        for (int i = 0; i < 5 && i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        return list;
    }

}