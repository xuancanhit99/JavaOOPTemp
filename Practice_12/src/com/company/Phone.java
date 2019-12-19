package com.company;

public class Phone {
    private String code;
    private String number;

    private static final Character plus = '+';
    private static final Character eight = '8';

    public Phone(String num) {
        if (num.charAt(0) == '8'){
            code   = "8";
            number = num.substring(1);
        } else {
            code   = num.substring(1, num.length()-10);
            number = num.substring(num.length()-10);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("+");
        builder.append(code).append(number);
        builder.insert(code.length() + 4, '-');
        builder.insert(code.length() + 8, '-');
        return builder.toString();
    }
}