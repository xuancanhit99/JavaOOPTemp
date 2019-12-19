package com.company;

interface Nameable {
    String getName();
}

class Furniture implements Nameable {

    private String name;
    private String material;

    Furniture(String name, String material){
        this.name = name;
        this.material = material;
    }

    @Override
    public String getName() {
        return name;
    }
}

class City implements Nameable {

    private String name;
    private int population;

    City(String name, int population){
        this.name = name;
        this.population = population;
    }

    @Override
    public String getName() {
        return name;
    }
}

public class Main {

    public static void main(String[] args) {

        Nameable[] nameables = {
            new City("Moscow", 11920000),
            new City("Tomsk", 543596),
            new Furniture("Bench", "plastic"),
            new Furniture("Cupboard", "wood")
        };

        for(Nameable now : nameables){
            System.out.print(now.getName() + ", ");
        }
    }
}
