package com.company;

public class Student implements Comparable<Student> {
    private String name;
    private double avgScore;

    public Student(String name, double avgScore) {
        this.name = name;
        this.avgScore = avgScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student s) {
        if (s.getAvgScore() - this.avgScore > 0.0) {
            return 1;
        } else {
            if (s.getAvgScore() == this.avgScore) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "name: " + name +", score: " + avgScore;
    }
}