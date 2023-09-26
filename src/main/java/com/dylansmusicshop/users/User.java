package com.dylansmusicshop.users;


public class User {
    private long id;
    private String username;
    private String password;

    private String email;
    private String authorities;

    public long getID() {
        return  id;
    }
    public void setID(long id) {
        this.id = id;
    }

    public String getUsername() {
        return  username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return  email;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public String getPassword() {
        return  password;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getAuthorities() { return authorities; }
    public String setAuthorities(String authority) { return authority; }

}
