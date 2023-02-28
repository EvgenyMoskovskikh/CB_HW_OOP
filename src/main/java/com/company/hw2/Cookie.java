package com.company.hw2;

public class Cookie extends Product{
    private String filling;
    private String type;

    public Cookie(String name, double price, String filling, String type) {
        super(name, price);
        this.filling = filling;
        this.type = type;
    }
}
