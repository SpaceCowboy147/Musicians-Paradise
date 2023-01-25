package com.dylansmusicshop.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
public void passwordEncoder() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

}
    }

