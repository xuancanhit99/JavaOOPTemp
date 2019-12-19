package com.company;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI {

    private static final int TABLES_COUNT = 10;
    private static final String WORD_REGEX = "^[a-zA-Z\\-]+$";
    private static final String CHAR_REGEX = "^[a-zA-Z0-9]$";
    private static final String NUM_REGEX  = "^\\d+$";
    private static final MenuItem[] menu = {
            new Dish(49,  "Salad",   "Caesar salad"  ),
            new Dish(49,  "Soup",    "just soup"     ),
            new Dish(99,  "Rice",    "boiled rice"   ),
            new Dish(49,  "Cutlet",  "beef"          ),
            new Dish(149, "Dessert", "chocolate cake"),
            new Drink(DrinkTypeEnum.BEER,         79,  "Baltic 9",     "just bear" ),
            new Drink(DrinkTypeEnum.BLACK_TEA,    49,  "Greenfield",   "tea bag"   ),
            new Drink(DrinkTypeEnum.JUICE,        49,  "Every day",    "good juice"),
            new Drink(DrinkTypeEnum.TEQUILA,      199, "Olmeca",       "tequila"   ),
            new Drink(DrinkTypeEnum.JAGERMEISTER, 399, "Jagermeister", "liquor"    ),
    };

    private static Scanner scanner = new Scanner(System.in);
    private static OrdersManager ordersManager;
    private static InternetOrdersManager internetOrdersManager;
    private static TableOrdersManager tableOrdersManager;
    private static int table;

    public static void script() throws IllegalTableNumber, OrderAlreadyAddedException {
        System.out.println("Welcome to our restaurant!");
        enterOrdersManager();
        Customer customer = enterCustomer();
        System.out.println();
        if (internetOrdersManager == null) {
            placeTableOrder();
        } else {
            placeInternetOrder();
        }
        System.out.println("\nDear " + customer.getFirstName() + "!");
        showCheckForPayment(0);
    }

    private static String enter(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        System.out.print(text);
        String input = scanner.nextLine();
        while (!pattern.matcher(input).find()) {
            System.out.print(" > Incorrect input!\n" + text);
            input = scanner.nextLine();
        }
        return input;
    }

    private static Customer enterCustomer() {
        System.out.println("Who are you?");
        String firstName  = enter("First name: ",  WORD_REGEX);
        String secondName = enter("Second name: ", WORD_REGEX);
        int age = Integer.parseInt(enter("Age: ", NUM_REGEX));
        Address address = (tableOrdersManager == null) ? enterAddress() : Address.EMPTY_ADDRESS;
        return new Customer(firstName, secondName, age, address);
    }

    private static Address enterAddress() {
        System.out.println("Enter your address:");
        String city = enter("City: ", WORD_REGEX);
        int zipCode = Integer.parseInt(enter("Zip code: ", NUM_REGEX));
        String street = enter("Street: ", WORD_REGEX);
        int building = Integer.parseInt(enter("Building number: ", NUM_REGEX));
        char letter = enter("Letter of building: ", CHAR_REGEX).charAt(0);
        int apartment = Integer.parseInt(enter("Apartment number: ", NUM_REGEX));
        return new Address(city, zipCode, street, building, letter, apartment);
    }

    private static void enterOrdersManager(){
        System.out.println("Where do you want to place an order?");
        System.out.println("[1] - from internet");
        System.out.println("[2] - from restaurant");
        while (true) {
            String answer = enter("", CHAR_REGEX);
            switch (answer) {
                case "1":
                    internetOrdersManager = new InternetOrdersManager();
                    ordersManager = internetOrdersManager;
                    return;
                case "2":
                    tableOrdersManager = new TableOrdersManager(TABLES_COUNT);
                    ordersManager = tableOrdersManager;
                    table = tableOrdersManager.freeTableNumber();
                    System.out.println("Your table is " + table + ".");
                    return;
                default:
                    System.out.println(" > Incorrect input!");
            }
        }
    }

    private static void showAssortment() {
        for (int i = 0; i < menu.length; ++i) {
            System.out.print("[" + i + "] ");
            System.out.print(menu[i].getName() + " - ");
            System.out.print(menu[i].getDescription() + " (");
            System.out.print(menu[i].getCost() + "r.)\n");
        }
    }

    private static void placeInternetOrder() {
        InternetOrder newOrder = new InternetOrder();
        while (true) {
            System.out.println("What do you want to add to your order?");
            showAssortment();

            String choice = scanner.nextLine();
            try {
                newOrder.add(menu[Integer.parseInt(choice)]);
            } catch (NumberFormatException e) {
                System.out.println(" > Incorrect input!");
            }
            System.out.println("Add more dishes/drinks?");
            System.out.println("[1] - yes");
            System.out.println("[!1] - no");

            if (!scanner.nextLine().equals("1")) break;
        }
        newOrder.sortedItemsByCostDesc();
        internetOrdersManager.add(newOrder);
    }

    private static void placeTableOrder() throws IllegalTableNumber, OrderAlreadyAddedException {
        TableOrder newOrder = new TableOrder();
        while (true) {
            System.out.println("What do you want to add to your order?");
            showAssortment();

            String choice = scanner.nextLine();
            try {
                newOrder.add(menu[Integer.parseInt(choice)]);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
            System.out.println("Add more dishes/drinks?");
            System.out.println("[1] - yes");
            System.out.println("[!1] - no");

            if (!scanner.nextLine().equals("1")) break;
        }
        newOrder.sortedItemsByCostDesc();
        tableOrdersManager.add(newOrder, table);
    }

    private static void showCheckForPayment(int orderIndex) {
        System.out.println("Your order:");
        MenuItem[] order = ordersManager.getOrders()[orderIndex].getItems();
        for (int i = 0; i < order.length; ++i) {
            System.out.print(order[i].getName() + " - ");
            System.out.print(order[i].getDescription() + " (");
            System.out.print(order[i].getCost() + "r.)\n");
        }
        System.out.println("---------------");
        System.out.println("Total cost: " + ordersManager.ordersCostSummary());
    }
}
