package com.dylansmusicshop.products;

public class Colors {

    int id;
    String color_name;


    private void setID(int id) {
        this.id = id; }

    private int getId() {
        return id;
    }
    private void setColor(String color) {
        this.color_name = color;
    }
    private String getColor() {
        return color_name;
    }
}
