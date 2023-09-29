package com.dylansmusicshop.products;

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

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {

        this.price = price;
    }


}




