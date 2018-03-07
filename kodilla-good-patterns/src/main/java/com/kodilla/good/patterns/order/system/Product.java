package com.kodilla.good.patterns.order.system;

public class Product {
    private String name;
    private String unit;
    private double price;

    Product(String name, String unit, double price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }
}
