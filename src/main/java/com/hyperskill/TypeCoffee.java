package com.hyperskill;

public enum TypeCoffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6),
    BACK(0, 0, 0, 0),
    NOT_EXIT(0, 0, 0, 0);

    private final int water;
    private final int milk;
    private final int coffee;
    private final int price;


    TypeCoffee(int water, int milk, int coffee, int price) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.price = price;
    }

    public static TypeCoffee getType(String type) {
        return switch (type) {
            case "1" -> ESPRESSO;
            case "2" -> LATTE;
            case "3" -> CAPPUCCINO;
            case "back" -> BACK;
            default -> NOT_EXIT;
        };
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getPrice() {
        return price;
    }
}