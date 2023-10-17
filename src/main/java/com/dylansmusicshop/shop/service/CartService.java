package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.shop.RowMappers.CartItemRowMapper;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartRepo;
import org.springframework.jdbc.core.JdbcTemplate;

public class CartService implements CartRepo {

    JdbcTemplate jdbcTemplate;

    @Override
    public CartItem showItemsInCart() {

        String sql = "SELECT * FROM cart_items";
        return jdbcTemplate.queryForObject(sql, new CartItemRowMapper());
    }
}



