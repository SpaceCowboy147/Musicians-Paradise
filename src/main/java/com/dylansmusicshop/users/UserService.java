package com.dylansmusicshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;
//
//    @Autowired
//    public UserService(UserRepo userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException(username);

        }
        return (UserDetails) user;
    }
}
