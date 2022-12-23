package com.hyperskill;

public class Storage {
    private int water;
    private int milk;
    private int caffe;
    private int cups;

    public Storage(int water, int milk, int caffe, int cups) {
        this.water = water;
        this.milk = milk;
        this.caffe = caffe;
        this.cups = cups;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCaffe() {
        return caffe;
    }

    public int getCups() {
        return cups;
    }

    public void consumeResources(TypeCoffee typeCoffee) {
        this.water -= typeCoffee.getWater() != 0 ? typeCoffee.getWater() : 0;
        this.milk -= typeCoffee.getMilk() != 0 ? typeCoffee.getMilk() : 0;
        this.caffe -= typeCoffee.getCoffee() != 0 ? typeCoffee.getCoffee() : 0;
        this.cups--;
    }

    public boolean validateResources(TypeCoffee typeCoffee) {
        if (this.water < typeCoffee.getWater()) {
            System.out.println("Sorry, not enough water!\n");
            return false;
        }
        if (this.milk < typeCoffee.getMilk()) {
            System.out.println("Sorry, not enough milk!\n");
            return false;
        }
        if (this.caffe < typeCoffee.getCoffee()) {
            System.out.println("Sorry, not enough caffe!\n");
            return false;
        }
        if (this.cups == 0) {
            System.out.println("Sorry, not enough cups!\n");
            return false;
        }
        return true;
    }

    public void updateStorage(int water, int milk, int caffe, int cups) {
        this.water += water;
        this.milk += milk;
        this.caffe += caffe;
        this.cups += cups;
    }
}