package com.company;

import java.util.Scanner;

public class Main {

    static int unitsCount() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num == 0) {
            num = scanner.nextInt();
            if (num == 0) return 0;
        }

        if (num == 1)
            return 1 + unitsCount();
        else
            return unitsCount();
    }

    public static void main(String[] args) {
        System.out.println("Enter sequence:");
        System.out.println("Count of ones: " + unitsCount());
    }
}
