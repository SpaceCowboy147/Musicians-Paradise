package com.dylansmusicshop.users;


public class User {
    private long id;
    private String username;
    private String password;
    private String authorities;

    public long getID() {
        return  id;
    }
    public long setID(long id) {
        return this.id = id;
    }

    public String getUsername() {
        return  username;
    }
    public String setUsername(String username) {
        return this.username = username;
    }

    public String getPassword() {
        return  password;
    }
    public String setPassword(String newPassword) {
        return this.password = newPassword;
    }

    public String getAuthorities() { return authorities; }
    public String setAuthorities(String authority) { return authority; }

}
