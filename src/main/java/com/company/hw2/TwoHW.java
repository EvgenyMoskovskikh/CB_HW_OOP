package com.company.hw2;

import com.company.helper.ScannerHelper;

public class TwoHW {
    private static Machine machine = initialProducts();

    public static void viewAllProducts(){
        machine.viewProducts();
    }

    public static void buyProducts(){
        String buy = ScannerHelper.getIntFromString("Введите название продукта, который хотите купить: ");
        machine.buyProduct(buy);
    }

    public static void addProducts(){
        String addProduct = ScannerHelper.getIntFromString("Какую категорию товара нужно добавить? " +
                "\n\t1 - шоколад,\n\t2 - вода,\n\t3 - печенье\n");
        if(addProduct.equals("1") || addProduct.equals("шоколад")) {
            String name = ScannerHelper.getIntFromString("Введите название шоколада: ");
            double price = ScannerHelper.getDoubleFromInput("Введите стоимость шоколада: ");
            machine.addProduct(name, price);
        }
        else if (addProduct.equals("2") || addProduct.equals("вода")){
            String name = ScannerHelper.getIntFromString("Введите название воды: ");
            double price = ScannerHelper.getDoubleFromInput("Введите стоимость воды: ");
            String soda = ScannerHelper.getIntFromString("Введите вода с газом или нет: ");
            machine.addProduct(name, price, soda);
        }
        else if(addProduct.equals("3") || addProduct.equals("печенье")){
            String name = ScannerHelper.getIntFromString("Введите название печенья: ");
            double price = ScannerHelper.getDoubleFromInput("Введите стоимость печенья: ");
            String filling = ScannerHelper.getIntFromString("С какой начинкой печенье: ");
            String type = ScannerHelper.getIntFromString("Введите тип печенья: ");
            machine.addProduct(name, price, filling, type);
        }
        else {
            System.out.println("Такого автомат не продает!");
        }

    }

    private static Machine initialProducts(){
        Machine machine = new Machine();
        machine.addProduct("Twix", 52);
        machine.addProduct("Mars", 52);
        machine.addProduct("Nuts", 52);
        machine.addProduct("BonAqua",40, "Газированная");
        machine.addProduct("AquaMinerale",35, "Без газа");
        machine.addProduct("Cola",45, "Сильно-газированная");
        machine.addProduct("Oreo", 35, "шоколадная", "печенье-сендвич");
        machine.addProduct("Юбилейное", 25, "нет", "печочное");
        return machine;
    }
}
