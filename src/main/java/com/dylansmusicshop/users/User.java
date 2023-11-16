package com.dylansmusicshop.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    private String email;
    private String authorities;

    private boolean enabled;

    public int getID() {
        return  id;
    }
    public void setID(int id) {
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
    public void setAuthorities(String authority) { this.authorities = authority;
    }
    public boolean getEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled;
    }

}
