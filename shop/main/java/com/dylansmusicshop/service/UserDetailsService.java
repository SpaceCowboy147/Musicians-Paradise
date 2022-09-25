package com.dylansmusicshop.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsService {

    private Map<String, User> roles = new HashMap<>();
}
