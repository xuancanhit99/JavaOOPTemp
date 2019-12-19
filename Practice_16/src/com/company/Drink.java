package com.company;

public final class Drink implements Item{
    private static final double ZERO_COST = 0.0;

    private final double cost;
    private final String name;
    private final String description;

    public Drink(String name, String description){
        this(ZERO_COST, name, description);
    }

    public Drink(double cost, String name, String description) throws IllegalArgumentException{
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

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
