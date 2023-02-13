package com.company.hw1;

public abstract class Car {
    private String model;
    private int year;
    private double price;
    private String color;
    private double power;
    private int startSpeed = 0;

    public Car(String model, int year, double price, String color, double power) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.power = power;
    }

    public abstract void getInfo();

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public double getPower() {
        return power;
    }

    public int getStartSpeed() {
        return startSpeed;
    }

    public void setStartSpeed(int startSpeed) {
        this.startSpeed = startSpeed;
    }

}
