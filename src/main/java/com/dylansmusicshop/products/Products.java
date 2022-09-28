package com.dylansmusicshop.products;

import java.util.Scanner;

public class Products {
    private String mainMenu;
    private String brand;
    private String color;

    private String model;
    private double price;


    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

}




