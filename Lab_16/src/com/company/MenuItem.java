package com.company;

class MenuItem {
    private static final double ZERO_COST = 0.0;
    private double cost;
    private String name;
    private String description;

    MenuItem(String name, String description){
        this(ZERO_COST, name, description);
    }

    MenuItem(double cost, String name, String description) throws IllegalArgumentException{
        if (cost < ZERO_COST){
            throw new IllegalArgumentException("Cost can`t be lower 0.");
        } else {
            if (name.isEmpty()){
                throw new IllegalArgumentException("Name must not be empty.");
            } else {
                if (description.isEmpty()){
                    throw new IllegalArgumentException("Description must not be empty.");
                } else {
                    this.cost = cost;
                    this.name = name;
                    this.description = description;
                }
            }
        }
    }

    double getCost(){ return cost; }
    String getName(){ return name; }
    String getDescription(){ return description; }
}
