package com.dylansmusicshop.users;

import java.util.List;

public interface UserRepo {
    User findByID(int id);

    User findByUsername(String username);

    List<User> findAll();

    User save(User user);

    void update(User user);

    void deleteByID(int id);

    int findUserIdByUsername(String username);

    int updateUsername(int userId, String newUsername);
    int updatePassword(String newPassword, int userId);
}
