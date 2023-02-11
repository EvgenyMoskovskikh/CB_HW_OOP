package com.company.hw1;

public class Car {
    private String model;
    private int year;
    private double price;
    private String color;
    private double power;
    private int numDoors;
    private String bodyType;
    private int startSpeed = 0;
    private boolean isStarted = false;

    public Car(String model, int year, double price, String color, double power, int numDoors, String bodyType) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.power = power;
        this.numDoors = numDoors;
        this.bodyType = bodyType;
    }

    public void getInfo () {
        System.out.println("Модель: " + model + ", год выпуска: " + year + ", цена: " + price + "б цвет: " + color
                + ", объем двигателя: " + power + ", количество дверей: " + numDoors + ", тип кузова: " + bodyType);
    }

    public void starCar(){
        this.isStarted = true;
    }

    public void stopCar() {
        this.isStarted = false;
    }

    public void road(String road) {
        if (!isStarted){
            System.out.println(model + " Извините, но машина не заведена! Мы не можем ехать!");
        }
        else {
            System.out.println(model + " поехала в город " + road);
        }
    }

    public void carWash(){
        this.isStarted = false;
        System.out.println(model + " находится в автомойке!");
    }

    public String getModel() {
        return model;
    }

    public int getStartSpeed() {
        return startSpeed;
    }

    public void setStartSpeed(int startSpeed) {
        this.startSpeed = startSpeed;
    }

}
