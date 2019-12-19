package com.company;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of exercise:");
        String number = scanner.nextLine();

        switch (number) {
            case "1":
                ex1(scanner);
                break;
            case "2":
                ex2(scanner);
                break;
            case "31":
                ex31(scanner);
                break;
            case "32":
                ex32(scanner);
                break;
            case "33":
                ex33(scanner);
                break;
            case "34":
                ex34(scanner);
                break;
            case "35":
                ex35(scanner);
                break;
            default:
                System.out.println("There isn't that exercise");
        }
    }

    static void ex1(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        System.out.println("Enter the RegEx:");
        Pattern pattern = Pattern.compile(scanner.nextLine());
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println(string.substring(matcher.start(), matcher.end()));
        }
    }

    static void ex2(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("^abcdefghijklmnopqrstuv18340$");
        Matcher matcher = pattern.matcher(string);

        System.out.println(matcher.find() ? "YES" : "NO");
    }

    static void ex31(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?\\s(USD|RUB|EU))+");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println(string.substring(matcher.start(), matcher.end()));
        }
    }

    static void ex32(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d\\s?\\+");
        Matcher matcher = pattern.matcher(string);

        System.out.println(matcher.find() ? "YES" : "NO");
    }

    static void ex33(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(string);
            System.out.println("YES");
            return;
        } catch (Exception ignored) {}

        System.out.println("NO");
    }

    static void ex34(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?^`{|}~-]+@((\\w+(\\.\\w+)+)|localhost)$");
        Matcher matcher = pattern.matcher(string);

        System.out.println(matcher.find() ? "YES" : "NO");
    }

    static void ex35(Scanner scanner) {
        System.out.println("Enter the string:");
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*\\d.*)\\w{8,}$");
        Matcher matcher = pattern.matcher(string);

        System.out.println(matcher.find() ? "YES" : "NO");
    }
}
