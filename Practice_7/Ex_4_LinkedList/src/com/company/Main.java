package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static LinkedList<Integer> list1 = new LinkedList<>();
    private static LinkedList<Integer> list2 = new LinkedList<>();

    private static boolean compareCard(int c1, int c2) {
        if (c1 == 0 && c2 == 9) return true;
        if (c1 == 9 && c2 == 0) return false;
        return (c1 > c2);
    }

    private static void play() {
        int steps = 0;

        while (!list1.isEmpty() && !list2.isEmpty()) {
            steps++;
            if (steps > 106) {
                System.out.println("botva");
                return;
            }

            int c1 = list1.remove();
            int c2 = list2.remove();

            if (compareCard(c1, c2)) {
                list1.add(c1);
                list1.add(c2);
            } else {
                list2.add(c1);
                list2.add(c2);
            }
        }

        if (list1.isEmpty())
            System.out.print("second ");
        else
            System.out.print("first ");
        System.out.println(steps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) list1.add(scanner.nextInt());
        for (int j = 0; j < 5; ++j) list2.add(scanner.nextInt());

        play();
    }
}
