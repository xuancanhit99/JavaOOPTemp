package com.company;

class Book{

    private String name;
    private String author;
    private int year;
    private int pageCount;

    public Book(String name, String author, int year, int pageCount){
        this.name = name;
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
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

    public int getPageCount() {
        return pageCount;
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

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book("The Dark Tower", "S. E. King", 1982, 1304);
        book.setPageCount(2000);

        System.out.print("The book '" + book.getName() + "' ");
        System.out.print("with " + Integer.toString(book.getPageCount()) + " pages ");
        System.out.print("was written in " + Integer.toString(book.getYear()) + " ");
        System.out.print("by " + book.getAuthor() + ".\n");
    }
}

