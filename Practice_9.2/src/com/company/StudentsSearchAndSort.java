package com.company;

import java.util.Collections;
import java.util.LinkedList;

public class StudentsSearchAndSort implements SearchAndSort {

    private LinkedList<Student> students = new LinkedList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void sort() {
        Collections.sort(students);
    }

    @Override
    public Student search(String name) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException("there isn't student " + name);
    }

    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < students.size(); ++i) {
            tmp += (i != 0 ? "\n" : "");
            tmp += students.get(i).toString();
        }
        return tmp;
    }
}
