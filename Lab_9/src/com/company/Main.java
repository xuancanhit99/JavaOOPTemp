package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Exception1.exceptionDemo();           // 1-4

//        ThrowsDemo.printMessage(null);        // 5
//        ThrowsDemo.printMessage("me");

        //ThrowsDemo.getKey();                  // 6

        ThrowsDemo.getKey();                    // 7-8
    }
}

class Exception1 {
    static void exceptionDemo() {
        // 1
//        try {
//            System.out.println(2 / 0);
//        } catch(ArithmeticException ex) {
//            System.out.println("Attempted division by zero");
//        }

        // 2
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        String intStr = myScanner.next();

        try {
            int i = Integer.parseInt(intStr);
            System.out.println(2 / i);
        }
        // 3
//        catch (Exception ex) {
//            System.out.println("All exceptions are here.");
//        }
        catch(ArithmeticException ex) {
            System.out.println("Attempted division by zero.");
        } catch(NumberFormatException ex) {
            System.out.println("Wrong type.");
        // 4
        } finally {
            System.out.println("Always it is here.");
        }
    }
}