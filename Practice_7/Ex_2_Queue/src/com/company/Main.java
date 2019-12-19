package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static Queue<Integer> queue1 = new LinkedList<>();
    private static Queue<Integer> queue2 = new LinkedList<>();

    private static boolean compareCard(int c1, int c2) {
        if (c1 == 0 && c2 == 9) return true;
        if (c1 == 9 && c2 == 0) return false;
        return (c1 > c2);
    }

    private static void play() {
        int steps = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            steps++;
            if (steps > 106) {
                System.out.println("botva");
                return;
            }

            int c1 = queue1.remove();
            int c2 = queue2.remove();

            if (compareCard(c1, c2)) {
                queue1.add(c1);
                queue1.add(c2);
            } else {
                queue2.add(c1);
                queue2.add(c2);
            }
        }

        if (queue1.isEmpty())
            System.out.print("second ");
        else
            System.out.print("first ");
        System.out.println(steps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) queue1.offer(scanner.nextInt());
        for (int j = 0; j < 5; ++j) queue2.offer(scanner.nextInt());

        play();
    }
}
