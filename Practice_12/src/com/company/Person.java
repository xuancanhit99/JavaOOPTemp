package com.company;

public class Person {
    private String name;
    private String surname;
    private String patronymic;

    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getFullName() {
        StringBuilder builder = new StringBuilder(surname);
        if (!name.isEmpty()){
            builder.append(' ').append(name.charAt(0)).append('.');
        }
        if (!patronymic.isEmpty()){
            builder.append(' ').append(patronymic.charAt(0)).append('.');
        }
        return builder.toString();
    }
}