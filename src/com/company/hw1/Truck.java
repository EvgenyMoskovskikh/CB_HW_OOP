package com.company.hw1;

public class Truck extends Car{

    private int cargoСapacity;
    private boolean isStarted = false;

    public Truck(String model, int year, double price, String color, double power, int cargoСapacity) {
        super(model, year, price, color, power);
        this.cargoСapacity = cargoСapacity;
    }

    public void starCar() {
        this.isStarted = true;
    }

    public void stopCar() {
        this.isStarted = false;
    }

    public void road(String road) {
        if (!isStarted) {
            System.out.println(getModel() + " Извините, но машина не заведена! Мы не можем ехать!");
        } else {
            System.out.println(getModel() + " поехала в город " + road);
        }
    }

    public void carWash() {
        this.isStarted = false;
        System.out.println(getModel() + " находится в автомойке!");
    }

    @Override
    public void getInfo() {
        System.out.println("Модель: " + getModel() + ", год выпуска: " + getYear() + ", цена: " + getPrice() +
                "б цвет: " + getColor() + ", объем двигателя: " + getPower() + ", вместимость груза: " + cargoСapacity);
    }
}
