package com.company;

import java.util.Scanner;

public class Main {

    private static void odd() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == 0) return;
        if (a % 2 == 1) System.out.println(a);
        odd();
    }

    public static void main(String[] args) {
        odd();
    }
}
