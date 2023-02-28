package com.company.hw1;

public class RacingCar extends Car{
    private int numDoors;
    private String bodyType;


    public RacingCar(String model, int year, double price, String color, double power, int numDoors, String bodyType) {
        super(model, year, price, color, power);
        this.numDoors = numDoors;
        this.bodyType = bodyType;
    }

    @Override
    public void getInfo() {
            System.out.println("Модель: " + getModel() + ", год выпуска: " + getYear() + ", цена: " + getPrice() +
                    "б цвет: " + getColor() + ", объем двигателя: " + getPower() +
                    ", количество дверей: " + numDoors + ", тип кузова: " + bodyType);
    }
}
