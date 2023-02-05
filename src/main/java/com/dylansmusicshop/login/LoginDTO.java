package com.dylansmusicshop.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public class LoginDTO implements UserDetails {
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String authorities;
    @NotNull
    @NotEmpty
    private boolean enabled;
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    }

