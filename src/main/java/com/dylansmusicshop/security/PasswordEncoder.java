package com.dylansmusicshop.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
public void passwordEncoder(String password) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    password = "Yeet";
passwordEncoder.encode(password);
System.out.println(passwordEncoder.encode(password));
}
    }

