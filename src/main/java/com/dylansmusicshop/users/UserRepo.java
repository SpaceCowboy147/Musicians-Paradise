package com.dylansmusicshop.users;

import java.util.List;

public interface UserRepo {
    User findByID(int id);

    User findByUsername(String username);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteByID(int id);
}
