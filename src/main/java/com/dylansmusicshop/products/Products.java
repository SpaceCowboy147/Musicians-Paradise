package com.dylansmusicshop.products;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Products {

    private int id;
    private String brand;
    private int colorId;
    private String model;
    private double price;


    public int getID() {
        return  id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public int getColorId() {
        return colorId;
    }
    public void setColor(int colorId) {
        this.colorId = colorId;
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

    public double getPrice() {
        return this.price;
    }


    public void setPrice(double price) {

        this.price = price;
    }



}




