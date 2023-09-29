package com.dylansmusicshop.shop;

public class Cart {
    private int id;
    private int itemAmountInCart;
    private double totalPrice;

    public int getId() { return id; }
    public void setId(int id) { this.id = id;
    }

    public int getItemAmountInCart() { return itemAmountInCart;}
    public void setItemAmountInCart(int itemAmount) { this.itemAmountInCart = itemAmount;
    }

    public double getTotalPrice() { return totalPrice;}
    public void setTotalPrice(double price) { this.totalPrice = price;
    }
}
