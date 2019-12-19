package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    private static ArrayDeque<Integer> deque1 = new ArrayDeque<>();
    private static ArrayDeque<Integer> deque2 = new ArrayDeque<>();

    private static boolean compareCard(int c1, int c2) {
        if (c1 == 0 && c2 == 9) return true;
        if (c1 == 9 && c2 == 0) return false;
        return (c1 > c2);
    }

    private static void play() {
        int steps = 0;

        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            steps++;
            if (steps > 106) {
                System.out.println("botva");
                return;
            }

            int c1 = deque1.remove();
            int c2 = deque2.remove();

            if (compareCard(c1, c2)) {
                deque1.add(c1);
                deque1.add(c2);
            } else {
                deque2.add(c1);
                deque2.add(c2);
            }
        }

        if (deque1.isEmpty())
            System.out.print("second ");
        else
            System.out.print("first ");
        System.out.println(steps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) deque1.add(scanner.nextInt());
        for (int j = 0; j < 5; ++j) deque2.add(scanner.nextInt());

        play();
    }
}
