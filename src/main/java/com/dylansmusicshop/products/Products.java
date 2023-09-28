package com.dylansmusicshop.products;

import java.util.Scanner;

public class Products {

    private int id;
    private String brand;
    private String color;
    private String model;
    private double price;

    public long getID() {
        return  id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {

        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {

        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setPrice(String price) {

        this.brand = price;
    }


}




