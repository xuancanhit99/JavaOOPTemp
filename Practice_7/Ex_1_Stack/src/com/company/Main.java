package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    private static Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> tmp = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; ++i) tmp.push(stack.pop());
        return tmp;
    }

    private static boolean compareCard(int c1, int c2) {
        if (c1 == 0 && c2 == 9) return true;
        if (c1 == 9 && c2 == 0) return false;
        return (c1 > c2);
    }

    private static void play() {
        int steps = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            steps++;
            if (steps > 106) {
                System.out.println("botva");
                return;
            }

            int c1 = stack1.pop();
            int c2 = stack2.pop();

            if (compareCard(c1, c2)) {
                stack1 = reverse(stack1);
                stack1.push(c1);
                stack1.push(c2);
                stack1 = reverse(stack1);
            } else {
                stack2 = reverse(stack2);
                stack2.push(c1);
                stack2.push(c2);
                stack2 = reverse(stack2);
            }
        }

        if (stack1.isEmpty())
            System.out.print("second ");
        else
            System.out.print("first ");
        System.out.println(steps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) stack1.push(scanner.nextInt());
        for (int i = 0; i < 5; ++i) stack2.push(scanner.nextInt());

        stack1 = reverse(stack1);
        stack2 = reverse(stack2);

        play();
    }
}
