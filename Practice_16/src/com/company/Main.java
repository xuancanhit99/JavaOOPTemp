package com.company;

public class Main {

    public static void main(String[] args) {
        Item[] internetItems = new Item[5];
        internetItems[0] = new Drink(49.9, "Coffee",   "3 in 1"     );
        internetItems[1] = new Dish( 10,   "Doshirak", "Beef flavor");
        internetItems[2] = new Dish( 20,   "Bread",    "Borodinskiy");
        internetItems[3] = new Drink(55,   "Tee",      "Tee bags"   );
        internetItems[4] = new Drink(1000, "Water",    "Holy spring");

        InternetOrder internetOrders = new InternetOrder(internetItems);
        internetOrders.add(new Dish(30, "Yogurt", "strawberry"));
        internetOrders.remove("Bread");
        for(Item item : internetOrders.sortedItemsByCostDesc()){
            System.out.println(item.getName());
        }

        System.out.println("\n");

        Item[] restaurantItems = new Item[5];
        restaurantItems[0] = new Drink(49.9, "Coffee",   "3 in 1"     );
        restaurantItems[1] = new Dish( 10,   "Doshirak", "Beef flavor");
        restaurantItems[2] = new Dish( 20,   "Bread",    "Borodinskiy");
        restaurantItems[3] = new Drink(55,   "Tee",      "Tee bags"   );
        restaurantItems[4] = new Drink(1000, "Water",    "Holy spring");

        RestaurantOrder restaurantOrders = new RestaurantOrder(internetItems);
        restaurantOrders.add(new Dish(30, "Yogurt", "strawberry"));
        restaurantOrders.remove("Bread");
        for(Item item : restaurantOrders.sortedItemsByCostDesc()){
            System.out.println(item.getName());
        }
    }
}
