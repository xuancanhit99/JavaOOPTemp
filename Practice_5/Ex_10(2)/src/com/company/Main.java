package com.company;

import java.util.Scanner;

public class Main {

    public static int reverse(int n, int i) {
        if (n == 0) {
            return i;
        } else {
            return reverse( n/10, i*10 + n%10 );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(reverse(n, 0));
    }
}
