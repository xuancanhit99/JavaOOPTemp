package com.company;

import java.util.ArrayList;

abstract class Furniture {

    private String material;
    private String type;
    private int price;

    public Furniture(String type, String material, int price){
        this.material = material;
        this.type = type;
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return "Type: " + type + "; material: " + material;
    }

}

class Cupboard extends Furniture {

    private int shellCount;
    private int height;

    public Cupboard(String material, int shellCount, int height, int price){
        super("Cupboard", material, price);
        this.shellCount = shellCount;
        this.height = height;
    }

    public int getShellCount() {
        return shellCount;
    }

    public void setShellCount(int shellCount) {
        this.shellCount = shellCount;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "; height: " + height +
                "; shell count: " + shellCount;
    }

}

class Bench extends Furniture {

    private int length;

    public Bench(String material, int length, int price){
        super("Bench", material, price);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "; length: " + length;
    }

}

class FurnitureShop {

    private ArrayList<Furniture> items = new ArrayList<>();

    public FurnitureShop() { }

    public void addItem(Furniture furniture) {
        items.add(furniture);
    }

    public void showItems() {
        for (Furniture f : items) {
            System.out.print("[$" + f.getPrice() + "] ");
            System.out.println(f.getDescription() + ".");
        }
    }

}

public class Main {

    public static void main(String[] args) {

        FurnitureShop shop = new FurnitureShop();
        Cupboard cb1 = new Cupboard("wood", 10, 4,6000);
        Cupboard cb2 = new Cupboard("steel", 5, 2,4000);
        Bench bench = new Bench("wood", 10, 1000);

        shop.addItem(cb1);
        shop.addItem(cb2);
        shop.addItem(bench);

        shop.showItems();

    }
}

