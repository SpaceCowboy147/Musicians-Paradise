package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.shop.RowMappers.CartItemRowMapper;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

public class CartItemService implements CartItemRepo {

    private  JdbcTemplate jdbcTemplate;

    @Override
    public CartItem addToCart() {
        CartItem cartItem = new CartItem();
        String sql = "INSERT INTO cart_item(product_id, price, quantity) values (?, ?, ?)";
        jdbcTemplate.update(sql, cartItem.getProductId(), cartItem.getQuantity(), cartItem.getPrice());
        String selectSql = "SELECT * FROM cart_item WHERE product_id = ?";
        return jdbcTemplate.queryForObject(selectSql, new Object[]{cartItem.getProductId()}, new CartItemRowMapper());
    }

}
