package com.company.hw1;

import com.company.helper.ScannerHelper;

import java.util.ArrayList;
import java.util.Collections;

public class OneHW {

    public static void viewAllCars(){
        ArrayList<RacingCar> racingCars = initialRacingCars();
        System.out.println("Наш автопарк гоночных машин: ");
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).getInfo();
        }
        ArrayList<Truck> trucks = initialTruck();
        System.out.println("\nНаш автопарк грузовых машин: ");
        for (int i = 0; i < trucks.size(); i++) {
            trucks.get(i).getInfo();
        }
    }

    public static void movingTrucks() {
        ArrayList<Truck> trucks = initialTruck();
        trucks.get(0).starCar();
        trucks.get(0).road("Москва");
        trucks.get(2).carWash();
        trucks.get(1).road("Питер");
        trucks.get(2).starCar();
        trucks.get(2).road("Питер");
        trucks.get(3).starCar();
    }

    public static String race() {
        ArrayList<RacingCar> cars = initialRacingCars();
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


    private static ArrayList<RacingCar> initialRacingCars() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        RacingCar bmv = new RacingCar("BMV", 2022, 6000000, "black", 2.4, 3, "седан");
        RacingCar toyota = new RacingCar("Toyota", 2020, 3000000, "white", 1.6, 3, "седан");
        RacingCar mercedes = new RacingCar("Mercedes", 2021, 5600000, "black", 2.4, 5, "седан");
        RacingCar lada = new RacingCar("Lada", 2020, 1500000, "white", 1.4, 5, "хэтчбэк");
        RacingCar audi = new RacingCar("Audi", 2021, 6500000, "white", 2.8, 3, "кабриолет");
        RacingCar nissan = new RacingCar("Nissan", 2020, 7000000, "white", 2.4, 3, "кабриолет");
        RacingCar lotus = new RacingCar("Lotus", 2020, 8000000, "red", 2.8, 3, "кабриолет");
        RacingCar hyundai = new RacingCar("Hyundai", 20220, 1500000, "yellow", 2.4, 5, "хэтчбэк");
        Collections.addAll(cars, bmv, toyota, mercedes, lada, audi, nissan, lotus, hyundai);
        return cars;
    }

    private static ArrayList<Truck> initialTruck() {
        ArrayList<Truck> trucks = new ArrayList<>();
        Truck sollers = new Truck("Развозной Sollers: Arg", 2022, 8000000, "white", 2.0,980);
        Truck kamazSed = new Truck("Седельный тягач КамАЗ-54901", 2021, 6000000, "white", 2.0,1780);
        Truck kamazBort = new Truck("Бортовой КамАЗ-65207", 2017, 7000000, "white", 2.4,1980);
        Truck gazPickUp = new Truck("Мега-пикап ГАЗ Вепрь-Next", 2022, 8500000, "white", 2.1,580);
        Collections.addAll(trucks, sollers, kamazSed, kamazBort,gazPickUp);
        return trucks;
    }


}
