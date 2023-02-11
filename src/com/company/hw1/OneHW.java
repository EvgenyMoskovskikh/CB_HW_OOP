package com.company.hw1;

import com.company.helper.ScannerHelper;

import java.util.ArrayList;
import java.util.Collections;

public class OneHW {

    public static void viewAllCars(){
        ArrayList<Car> cars = initialCars();
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).getInfo();
        }
    }

    public static void carLife() {
        ArrayList<Car> cars = initialCars();
        cars.get(0).starCar();
        cars.get(0).road("Москва");
        cars.get(7).carWash();
        cars.get(5).carWash();
        cars.get(5).road("Питер");
        cars.get(3).starCar();
        cars.get(3).road("Питер");
        cars.get(2).starCar();
    }

    public static String race() {
        ArrayList<Car> cars = initialCars();
        try {
            int minTracks = 200;
            int maxTracks = 2000;
            int distance = ScannerHelper.numRandom(minTracks, maxTracks);
            int maxSpeed = ScannerHelper.numRandom(200, 320);
            int speedIncrease = ScannerHelper.numRandom(1, 6);
            int speedNow = 0;
            System.out.println("Трасса, протяженностью " + distance + " км.");
            Thread.sleep(1000);
            System.out.println("\tОдин.....");
            Thread.sleep(1000);
            System.out.println("\tДва......");
            Thread.sleep(1000);
            System.out.println("\tСТАРТ!!!");
            Thread.sleep(1000);
            for (int i = 0; i < maxSpeed; i++) {
                for (int j = 0; j < cars.size(); j++) {
                    int randIndCars = ScannerHelper.numRandom(0, cars.size() - 1);
                    if (cars.get(j).getStartSpeed() >= maxSpeed) {

                        System.out.print("УРА!! Победа!!! Максимальная скорость в этом заезде: "
                                + cars.get(j).getStartSpeed() + " \nПОБЕДИТЕЛЬ: ");
                        return cars.get(j).getModel();
                    } else {
                        cars.get(randIndCars).setStartSpeed(speedNow + speedIncrease);
                        speedNow += speedIncrease;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Кажется гонка отменилась (((";
    }


    private static ArrayList<Car> initialCars() {
        ArrayList<Car> cars = new ArrayList<>();
        Car bmv = new Car("BMV", 2022, 6000000, "black", 2.4, 3, "седан");
        Car toyota = new Car("Toyota", 2020, 3000000, "white", 1.6, 3, "седан");
        Car mercedes = new Car("Mercedes", 2021, 5600000, "black", 2.4, 5, "седан");
        Car lada = new Car("Lada", 2020, 1500000, "white", 1.4, 5, "хэтчбэк");
        Car audi = new Car("Audi", 2021, 6500000, "white", 2.8, 3, "кабриолет");
        Car nissan = new Car("Nissan", 2020, 7000000, "white", 2.4, 3, "кабриолет");
        Car lotus = new Car("Lotus", 2020, 8000000, "red", 2.8, 3, "кабриолет");
        Car hyundai = new Car("Hyundai", 20220, 1500000, "yellow", 2.4, 5, "хэтчбэк");
        Collections.addAll(cars, bmv, toyota, mercedes, lada, audi, nissan, lotus, hyundai);
        return cars;
    }


}
