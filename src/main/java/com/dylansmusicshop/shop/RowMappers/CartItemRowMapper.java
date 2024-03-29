package com.dylansmusicshop.shop.RowMappers;

import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemRowMapper implements RowMapper<CartItem> {

    @Override
    public CartItem mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        CartItem cartItem = new CartItem();
        cartItem.setId(resultSet.getInt("id"));
        cartItem.setProductId(resultSet.getInt("product_id")); //foreign key
        cartItem.setCart_id(resultSet.getInt("cart_id")); //foreign key
        cartItem.setColorId(resultSet.getInt("color_id"));
        cartItem.setPrice(resultSet.getDouble("price"));
        cartItem.setQuantity(resultSet.getInt("quantity"));

        return cartItem;
    }
}
