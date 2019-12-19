package com.company;

class Dog {

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int humanAge() {
        return age * 7;
    }

    @Override
    public String toString() {
        return "Dog " + name + ", " + age + " years old";
    }
}

class Ball {

    private double radius;
    private String material;

    public Ball(double radius, String material) {
        this.radius = radius;
        this.material = material;
    }

    public double getRadius() {
        return radius;
    }

    public String getMaterial() {
        return material;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public double volume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    @Override
    public String toString() {
        return "Ball, radius = " + radius + ", material: " + material;
    }

}

class Book {

    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int howOldIsBook(int yearNow) {
        if (yearNow < year)
            return -1;
        else
            return yearNow - year;
    }

    @Override
    public String toString() {
        return "Book " + name + " by " + author + " (" + year + ")";
    }

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Sharic", 10);
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Ball ball = new Ball(book.howOldIsBook(2019), "steel");

        System.out.println("If the dog " + dog.getName() + " will read " +
                book.getName() + " every its human year, it will take " +
                dog.humanAge() + " years.\nSo, if " + dog.getName() +
                " would start to read since the book was written, " +
                book.getName() + " will be read by " + (book.getYear() + dog.humanAge()) +
                ".\nBy the way, the age of book is " + book.howOldIsBook(2019) +
                ".\nIf every year of this book's age was a meter of radius, " +
                "the ball with that radius would have volume ~" +
                (int)ball.volume() + " cube meters.");
    }
}
