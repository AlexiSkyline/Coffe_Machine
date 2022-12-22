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

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCaffe() {
        return caffe;
    }

    public void setCaffe(int caffe) {
        this.caffe = caffe;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }
}