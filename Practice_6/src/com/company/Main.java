package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the variant (1,2,3):");
        Scanner scanner = new Scanner(System.in);
        int variant = scanner.nextInt();
        switch (variant) {
            case 1:
                ex1();
                break;
            case 2:
                ex2();
                break;
            case 3:
                ex3();
                break;
            default:
                System.out.println("Uncorrected variant!");
        }
    }

    private static void ex1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        System.out.println("\nEnter students [name, id]:");
        for (int i = 0; i < n; ++i)
            students[i] = new Student(scanner.next(), scanner.nextInt());

        // sorting
        for (int i = 0; i < students.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (students[j - 1].getId() > students[j].getId()) {
                    Student tmp = students[j - 1];
                    students[j - 1] = students[j];
                    students[j] = tmp;
                }
            }
        }

        System.out.println("\nResult of sorting:");
        for (int i = 0; i < n; ++i)
            System.out.println(students[i]);
    }

    private static void ex2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        Student[] list = new Student[n];

        System.out.println("\nEnter students [name, score]:");
        for (int i = 0; i < n; ++i)
            list[i] = new Student(scanner.next(), i, scanner.nextInt());

        Arrays.sort(list, new SortingStudentsByGPA());
        System.out.println("\nResult of sorting:");
        for (int i = 0; i < n; ++i)
            System.out.println(list[i]);
    }

    private static void ex3() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<>();

        System.out.println("Enter the length of first list:");
        int n = scanner.nextInt();

        System.out.println("\nEnter students [name, score]:");
        for (int i = 0; i < n; ++i)
            list.add(new Student(scanner.next(), i, scanner.nextInt()));

        System.out.println("\nEnter the length of second list:");
        n = scanner.nextInt();

        System.out.println("\nEnter students [name, score]:");
        for (int i = 0; i < n; ++i)
            list.add(new Student(scanner.next(), i, scanner.nextInt()));

        Collections.sort(list, new SortByMerge());
        System.out.println("\nResult of sorting:");
        for (int i = 0; i < list.size(); ++i)
            System.out.println(list.get(i));

    }

    // Vasya 50 Vova 10 Petya 32 Jora 49 Kex 99
    // Ivan 58 Gregory 9 Nikita 77 Kalmar 11 Ork 89 Stella 10

}
