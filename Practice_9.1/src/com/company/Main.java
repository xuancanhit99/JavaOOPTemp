package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String inn = scanner.next();
        try {
            Client client = new Client(name, inn);
            System.out.println(client.toString());
        } catch (InnWrongException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// 123456789000