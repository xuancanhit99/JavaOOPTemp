package com.company;

import java.util.Scanner;

public class Main {

    static int comb(int a, int b, int last) {
        if (a == 0 && b == 0) return 1;
        if (a < 0 || b < 0)   return 0;

        if (last == 0)
            return comb(a, b-1, 1);
        else
            return comb(a-1, b, 0) + comb(a, b-1, 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a, b:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("There are " + comb(a, b, 1) + " combinations");
    }

}
