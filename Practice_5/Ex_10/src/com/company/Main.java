package com.company;

import java.util.Scanner;

public class Main {

    static int reverse(int n) {
        int len = Integer.toString(n).length();
        if(len == 1)
            return n;
        int tmp = n % 10;
        n /= 10;
        return tmp * (int)Math.pow(10, len-1) + reverse(n);
    }

    public static void main(String[] args) {
        System.out.println("Enter n:");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Reverse n: " + reverse(n));
    }
}
