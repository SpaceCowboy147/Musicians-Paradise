package com.dylansmusicshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean hasAdminRole(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {

            return user.getAuthorities().contains("admin");
        }
        return false;
    }

    public boolean hasUserRole(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {

            return user.getAuthorities().contains("user");
        }
        return false;
    }
}
