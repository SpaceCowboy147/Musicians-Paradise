package com.dylansmusicshop.users;

import com.dylansmusicshop.controller.RegistrationController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Users {

    private int id;
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    @RegistrationController.ValidEmail
    private String email;
    @NotNull
    @NotEmpty
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

