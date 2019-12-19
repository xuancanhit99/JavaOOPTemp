package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of exercise:");
        String number = scanner.nextLine();

        switch (number) {
            case "1":
                ex1();
                break;
            case "2":
                ex2();
                break;
            case "3":
                ex3(scanner);
                break;
            case "4":
                ex4();
                break;
            case "5":
                ex5(scanner);
                break;
            default:
                System.out.println("There isn't that exercise");
        }
    }

    static void ex1() {
        Person man = new Person("", "Ivanov", "Petrovich");
        System.out.println(man.getFullName());
    }

    static void ex2() {
        Address address1 = new Address("Russia-Khabarovsk region-Khabarovsk-Serisheva-33-1-1");
        Address address2 = new Address("Russia;Khabarovsk region;Khabarovsk;Serisheva,33;1;1");
        Address address4 = new Address("Russia.Khabarovsk region.Khabarovsk.Serisheva.33.1.1");
        Address address3 = new Address("Russia, Khabarovsk region, Khabarovsk, Serisheva, 33, 1, 1");

        address1.print();
        address2.print();
        address3.print();
        address4.print();
    }

    static void ex3(Scanner scanner) {
        String[] shirts = new String[11];

        shirts[0]  = "S001,Black Polo Shirt,Black,XL";
        shirts[1]  = "S002,Black Polo Shirt,Black,L";
        shirts[2]  = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3]  = "S004,Blue Polo Shirt,Blue,M";
        shirts[4]  = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5]  = "S006,Black T-Shirt,Black,XL";
        shirts[6]  = "S007,White T-Shirt,White,XL";
        shirts[7]  = "S008,White T-Shirt,White,L";
        shirts[8]  = "S009,Green T-Shirt,Green,S";
        shirts[9]  = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt shirt = new Shirt(shirts);

        System.out.println("Enter the index:");
        int index = scanner.nextInt();
        System.out.println(shirt.toString(index));
    }

    static void ex4() {
        Phone phone1 = new Phone("+79101236524");
        Phone phone2 = new Phone("+10428965211");
        Phone phone3 = new Phone("89001233223");

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
    }

    static void ex5(Scanner scanner) {
        System.out.println("Enter your string:");
        String string = scanner.nextLine();
        System.out.println(getLine(string));
    }

    static ArrayList<Integer> comb   = new ArrayList<>();
    static ArrayList<Boolean> used   = new ArrayList<>();
    static ArrayList<String>  answer = new ArrayList<>();

    private static String getLine(String string) {
        StringBuilder builder = new StringBuilder(string);
        LinkedList<String> words = new LinkedList<>();

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            words.add(string.substring(matcher.start(), matcher.end()));
        }

        for (int i = 0; i < words.size(); ++i) {
            used.add(false);
            comb.add(i);
            answer.add("");
        }

        rec(0, words);

        if (answer.get(0).isEmpty()) {
            return "It's impossible";
        } else {
            return answer.toString();
        }
    }

    static void rec(int pos, LinkedList<String> words) {
        if (pos == words.size()) {
            ArrayList<String>  tmp = new ArrayList<>();
            for (int i = 0; i < words.size(); ++i) {
                tmp.add(words.get(comb.get(i)));
            }
            if (isCorrect(tmp)) {
                answer = tmp;
            }
            return;
        }
        for (int i = 0; i < words.size(); ++i) {
            if (used.get(i)) continue;
            comb.set(pos, i);
            used.set(i, true);
            rec(pos+1, words);
            used.set(i, false);
        }
    }

    private static boolean isCorrect(ArrayList<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            Character firstChar = Character.toLowerCase(words.get(i+1).charAt(0));
            Character lastChar  = Character.toLowerCase(words.get(i).charAt(words.get(i).length()-1));
            if (firstChar != lastChar) {
                return false;
            }
        }
        return true;
    }
}