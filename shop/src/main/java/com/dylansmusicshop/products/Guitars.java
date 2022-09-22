package com.dylansmusicshop.products;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

    public class Guitars extends Products {

        //public LinkedList<String> guitarCart;

        public enum colors {

            BLUE, RED, GREEN, BLACK, WHITE, TOBACCO_SUNBURST, CYAN, VIOLET

        }


        public void guitarMain() {

            System.out.println("Press 1 for brands and models");
            System.out.println("Press 2 for color");
            System.out.println("Press 3 to add to cart");
            System.out.println("Press 4 for cart");
            System.out.println("Press 5 to go back");


            while (true) {
                Scanner guitarMenu = new Scanner(System.in);
                int choice = guitarMenu.nextInt();


                switch (choice) {

                    case 1:


                        System.out.println("Choose a brand:");
                        System.out.println("Press 1 for Fender");
                        System.out.println("Press 2 for Jackson");
                        System.out.println("Press 3 for Ibanez");
                        System.out.println("Press 4 for ESP");
                        System.out.println("Press 5 to get back");


                        while (true) {
                            Scanner s = new Scanner(System.in);
                            int brand = s.nextInt();

                            switch (brand) {
                                case 1:
                                    setBrand("Fender");
                                    System.out.println("Fender");


                                    System.out.println("Select a model: ");
                                    Scanner modelMenu = new Scanner(System.in);
                                    System.out.println("1: Stratocaster");
                                    System.out.println("2: Telecaster");
                                    int model = modelMenu.nextInt();
                                    while (true) {
                                        switch (model) {
                                            case 1:
                                                setModel("Stratocaster");
                                                System.out.println();
                                                guitarMain();

                                                break;
                                            case 2:
                                                setModel("Telecaster");
                                                System.out.println("Telecaster");
                                                guitarMain();
                                                break;

                                            case 3:
                                                guitarMain();
                                                break;
                                        }
                                    }
                                case 2:
                                    setBrand("Jackson");
                                    System.out.println("Jackson");
                                    guitarMain();
                                    break;


                                case 3:
                                    setBrand("Ibanez");
                                    System.out.println("Ibanzez");
                                    guitarMain();
                                    break;
                                case 4:
                                    setBrand("ESP");
                                    System.out.println("ESP");
                                    guitarMain();
                                    break;
                                case 5:
                                    guitarMain();
                                    guitarMain();
                                    break;


                            }
                        }

                    case 2:
                        System.out.println("Choose a color:");
                        System.out.println("Press 1 for Green");
                        System.out.println("Press 2 for Black");
                        System.out.println("Press 3 for Cyan");
                        System.out.println("Press 4 for White");
                        System.out.println("Press 5 for Purple");
                        System.out.println("Press 6 for Tobacco sunburst");
                        System.out.println("Press 7 to get red");
                        System.out.println("Press 8 to get blue");

                        while (true) {
                            Scanner colorMenu = new Scanner(System.in);
                            int color = colorMenu.nextInt();
                            switch (color) {

                                case 1:
                                    setColor(String.valueOf(colors.GREEN));
                                    guitarMain();
                                    break;
                                case 2:
                                    setColor(String.valueOf(colors.BLACK));
                                    guitarMain();
                                    break;
                                case 3:
                                    setColor(String.valueOf(colors.CYAN));
                                    guitarMain();
                                    break;
                                case 4:
                                    setColor(String.valueOf(colors.WHITE));
                                    guitarMain();
                                    break;
                                case 5:
                                    setColor(String.valueOf(colors.VIOLET));
                                    guitarMain();
                                    break;
                                case 6:
                                    setColor(String.valueOf(colors.TOBACCO_SUNBURST));
                                    guitarMain();
                                    break;
                                case 7:
                                    setColor(String.valueOf(colors.RED));
                                    guitarMain();
                                    break;
                                case 8:
                                    setColor(String.valueOf(colors.BLUE));
                                    guitarMain();
                                    break;
                                case 9:
                                    guitarMain();
                                    break;
                            }

                        }

                    case 3:
//                    Cart cart = new Cart();
//                  cart.addToCart();
                        System.out.println("Added to cart:");
                        addToCart();
                        guitarMain();
                        continue;

                    case 4:
                        cart();


                        break;

                    case 5:
                        MainMenu();
                        break;


                    default:
                        System.out.println("Error: Press 1 - 5");


                }

            }
        }

        public void addToCart() {
            // System.out.println("Added to cart:");
            System.out.println(getColor().toLowerCase(Locale.ROOT) + " " + getBrand() + " " + getModel());
            ArrayList<String> cart = new ArrayList<>();

//        while (true) {
            cart.add(getColor().toLowerCase(Locale.ROOT) + " " + getBrand() + " " + getModel());
//            cart.add(setColor() + setBrand() + setModel());
            System.out.println(cart);

        }

        public void cart() {

            System.out.println("Current cart:");
            System.out.println(getColor() + getBrand() + getModel());

        }


    }


