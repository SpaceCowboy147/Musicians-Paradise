package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.shop.RowMappers.CartItemRowMapper;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartService implements CartRepo {
@Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int saveUserWithCartId(int userID) {
        String sql = "INSERT into cart(customer_id) values (?)";

return jdbcTemplate.update(sql, userID);
    }

    @Override
    public boolean UserIdExistsWithCartId(int userId) {
        String sql = "SELECT id from cart where customer_id = ?";

        return true;
    }

    @Override
    public int getUserCartId(int userId) {
        String sql = "SELECT id from cart where customer_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, userId);
    }

}



