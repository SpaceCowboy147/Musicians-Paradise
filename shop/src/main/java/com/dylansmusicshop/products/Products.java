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

    public void setModel(String model) {
        this.model= model;
    }


    public static void MainMenu () {
        System.out.println("Pick a product");
        System.out.println("1 for guitars");
        System.out.println("2 for drums");
        while (true) {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Guitars guitars = new Guitars();
                    guitars.guitarMain();
                    guitars.guitarMain();

                    break;
                case 2:
                    Drums drums = new Drums();
                    drums.drumsMain();


                    break;

                default:
                    System.out.println("Error: Enter valid button");

            }
        }
    }
}




