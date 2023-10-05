package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.products.ProductRowMapper;
import com.dylansmusicshop.shop.entity.Cart;
import com.dylansmusicshop.shop.repositories.CartRepo;
import com.dylansmusicshop.users.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class CartService implements CartRepo {

    JdbcTemplate jdbcTemplate;
    User user;

    @Override
    public Cart showItemsInCart() {

        String sql = "SELECT * FROM cart_items";
        return null;
    }
}



