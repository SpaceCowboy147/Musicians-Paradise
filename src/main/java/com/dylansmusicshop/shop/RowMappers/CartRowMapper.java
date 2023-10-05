package com.dylansmusicshop.shop.RowMappers;

import com.dylansmusicshop.shop.entity.Cart;
import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(resultSet.getInt("id"));
        cart.setCustomerId(resultSet.getInt("customer_id")); //foreign key

        return cart;
    }
}
