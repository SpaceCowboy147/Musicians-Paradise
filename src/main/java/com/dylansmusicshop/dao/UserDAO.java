package com.dylansmusicshop.dao;

import com.dylansmusicshop.users.Users;

import java.util.List;
import java.util.Optional;

public class UserDAO implements Dao<Users>{
    @Override
    public Optional<Users> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void save(Users users) {

    }

    @Override
    public void update(Users users, String[] params) {

    }

    @Override
    public void delete(Users users) {

    }
}
