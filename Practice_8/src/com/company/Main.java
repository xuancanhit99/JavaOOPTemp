package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<IWaitList<Integer>> iWaitListArrayList = new ArrayList<>();

        // WaitList
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        WaitList<Integer> waitList = new WaitList<>(arrayList);
        waitList.add(1);
        waitList.add(2);
        waitList.add(3);
        System.out.println(waitList.remove() + " has been removed (collection)");

        // BoundedWaitList
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<>(3);
        for (int i = 0; i <= boundedWaitList.getCapacity() + 4; i++) {
            try{
                boundedWaitList.add(i + 1);
            } catch (RuntimeException e){
                System.out.println("Impossible to add " + (i + 1) + "element!");
            }
        }

        // UnfairWaitList
        UnfairWaitList<Integer> unfairWaitList = new UnfairWaitList<>();
        for (int i = 0; i < 4; i++) {
            unfairWaitList.add(i + 1);
        }
        unfairWaitList.remove(2);
        unfairWaitList.moveToBack(1);
//        iWaitListArrayList.add(unfairWaitList);

    }
}