package com.company;

public final class Dish extends MenuItem {

    public Dish(String name, String description){
        super(name, description);
    }

    public Dish(double cost, String name, String description) throws IllegalArgumentException{
        super(cost, name, description);
    }
}
