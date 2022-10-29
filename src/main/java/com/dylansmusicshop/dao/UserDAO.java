package com.dylansmusicshop.dao;

import com.dylansmusicshop.registration.UserDTO;


import java.util.List;
import java.util.Optional;

public class UserDAO implements Dao<UserDTO>{
    @Override
    public Optional<UserDTO> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public void save(UserDTO users) {

    }

    @Override
    public void update(UserDTO users, String[] params) {

    }

    @Override
    public void delete(UserDTO users) {

    }
}
