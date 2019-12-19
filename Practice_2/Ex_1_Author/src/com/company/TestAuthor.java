package com.company;

class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") at " + email;
    }
}

public class TestAuthor {

    public static void main(String[] args) {

        Author author1 = new Author("S.E.King", "unknown", 'M');
        author1.setEmail("king@gmail.com");

        Author author2 = new Author("J.K.Rowling", "rowling@mail.ru", 'F');

        System.out.println(author1 + ";");
        System.out.println(author2.getName() + " has gender " + author2.getGender() +
                " and email address: " + author2.getEmail() + ".");

    }
}
