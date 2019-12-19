package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentsSearchAndSort studentsSearchAndSort = new StudentsSearchAndSort();
        studentsSearchAndSort.addStudent(new Student("Ivan", 12));
        studentsSearchAndSort.addStudent(new Student("Vladimir", 100));
        studentsSearchAndSort.addStudent(new Student("Petr", 45));
        studentsSearchAndSort.addStudent(new Student("Steve", 87.4));
        studentsSearchAndSort.addStudent(new Student("Bob", 87.5));

        SearchAndSort[] searchAndSorts = {studentsSearchAndSort};
        System.out.println(searchAndSorts[0].toString() + '\n');
        searchAndSorts[0].sort();
        System.out.println(searchAndSorts[0].toString() + '\n');

        System.out.println("Enter the name for search:\n");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        try {
            System.out.println(searchAndSorts[0].search(name).toString());
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
