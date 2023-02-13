package com.company.hw2;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<Product> products;
    private final int maxCapacity;

    public Machine() {
        this.products = new ArrayList<>();
        this.maxCapacity = 20;
    }

    public void addProduct(String name, double price){
        if(products.size() < maxCapacity){
            Chocolate chocolate = new Chocolate(name, price);
            products.add(chocolate);
        }
        else {
            System.out.println("Автомат полный");
        }
    }
    public void addProduct(String name, double price, String soda){
        if(products.size() < maxCapacity){
            Soda sd = new Soda(name, price, soda);
            products.add(sd);
        }
        else {
            System.out.println("Автомат полный");
        }
    }
    public void addProduct(String name, double price, String filling, String type){
        if(products.size() < maxCapacity){
            Cookie sd = new Cookie(name, price, filling, type);
            products.add(sd);
        }
        else {
            System.out.println("Автомат полный");
        }
    }

    public void getProduct(String name){
        if (products.isEmpty()){
            System.out.println("Автомат пустой");
            return;
        }
        int num = chekProduct(name);
        if (num == -1){
            System.out.println("Товар отсутствует");
        }
        else {
            System.out.println("Заберите товар: " + name);
            products.remove(num);
        }
    }

    private int chekProduct(String name){
        int i = 0;
        for (Product pr: products) {
            if (pr.getName().equals(name)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void viewProducts(){
        if(products.isEmpty()){
            System.out.println("Ничего нет");
            return;
        }
        System.out.print("Доступные товары:\n");
        for (Product pr: products){
            System.out.println("\t" +  pr.getName() + " " + pr.getPrice() + " руб.");
        }
        System.out.println();
    }
}
