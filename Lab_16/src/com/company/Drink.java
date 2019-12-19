package com.company;

public final class Drink extends MenuItem implements Alcoholable{

    private double alcoholVol;
    private DrinkTypeEnum type;

    public Drink(DrinkTypeEnum type, String name, String description){
        super(name, description);
        setDrinkType(type);
    }

    public Drink(DrinkTypeEnum type, double cost, String name, String description) throws IllegalArgumentException{
        super(cost, name, description);
        setDrinkType(type);
    }

    private void setDrinkType(DrinkTypeEnum type){
        this.type = type;
        switch (type){
            case BEER:
                alcoholVol = 4;
                break;
            case WINE:
            case CHAMPAGNE:
                alcoholVol = 11;
                break;
            case VERMUTH:
                alcoholVol = 16;
                break;
            case LIQUOR:
            case JAGERMEISTER:
                alcoholVol = 35;
                break;
            case VODKA:
            case BRANDY:
            case WHISKEY:
            case TEQUILA:
            case RUM:
                alcoholVol = 40;
                break;
            case JUICE:
            case COFFEE:
            case GREEN_TEA:
            case BLACK_TEA:
            case MILK:
            case WATER:
            case SODA:
                alcoholVol = 0;
                break;
        }
    }

    DrinkTypeEnum getType(){ return type; }

    @Override
    public boolean isAlcoholicDrink() { return alcoholVol != 0; }

    @Override
    public double getAlcoholVol() { return alcoholVol; }
}