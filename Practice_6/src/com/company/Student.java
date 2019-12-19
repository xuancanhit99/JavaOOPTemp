package com.company;

public class Student {

    private String name;
    private int id;
    private int score;

    public Student(String name, int iDNumber) {
        this.name = name;
        this.id = iDNumber;
    }

    public Student(String name, int iDNumber, int score) {
        this.name = name;
        this.id = iDNumber;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " - (" + score + ")";
    }

}
