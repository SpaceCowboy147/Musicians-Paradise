package com.dylansmusicshop.users;

public class Users {

    private int id;
    private String username;
    private String password;
    private String email;
    private String shippingAddress;



    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    }

