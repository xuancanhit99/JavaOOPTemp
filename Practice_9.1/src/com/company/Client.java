package com.company;

public class Client {
    private String name;
    private String inn;

    public Client(String name, String inn) throws InnWrongException {
        this.name = name;
        if (isInnCorrect(inn)) {
            this.inn = new String(inn);
        } else {
            throw new InnWrongException("This is wrong INN: " + inn);
        }
    }

    public boolean isInnCorrect(String inn) {
        if(inn.length() != 12) {
            return false;
        }
        for (char ch : inn.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Name: " + name + ", INN: " + inn;
    }
}