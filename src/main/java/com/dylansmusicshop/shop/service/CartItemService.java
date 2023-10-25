package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.shop.RowMappers.CartItemRowMapper;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CartItemService implements CartItemRepo {

    private final JdbcTemplate jdbcTemplate;
    public CartItemService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public String FindModelByID(int productId) {
        String sql = "SELECT products.model FROM cart_item JOIN products ON cart_item.product_id = products.id  WHERE cart_item.product_id = ?";

        return jdbcTemplate.queryForObject(sql, String.class, productId);
    }

    @Override
    public CartItem addToCart(CartItem cartItem) {
        String sql = "INSERT INTO cart_item(product_id, cart_id, price, quantity, color_id) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cartItem.getProductId(),cartItem.getCart_id(), cartItem.getPrice(), cartItem.getQuantity(), cartItem.getColorId());
        String selectSql = "SELECT * FROM cart_item WHERE product_id = ?";
        return jdbcTemplate.queryForObject(selectSql, new Object[]{cartItem.getProductId()}, new CartItemRowMapper());

    }



    @Override
    public CartItem updateCart(CartItem cartItem) {
        String sql = "UPDATE cart_item SET price = price + ?, quantity = quantity + ? where product_id = ?";
        jdbcTemplate.update(sql, cartItem.getPrice(), cartItem.getQuantity(), cartItem.getProductId(), cartItem.getColorId());
        return cartItem;
    }

    @Override
    public List<CartItem> getAllFromCart(int userID) {
        //String sql = "SELECT * FROM cart_item";
        String sql = "SELECT p.model, c.quantity, c.price, c.id, c.product_id, c.cart_id\n" +
                "FROM cart_item c\n" +
                "JOIN products p ON c.product_id = p.id\n" +
                "JOIN cart ca ON c.cart_id = ca.id\n" +
                "WHERE ca.customer_id = ?";
        return jdbcTemplate.query(sql, new CartItemRowMapper(), userID);
    }
    public boolean isProductInCart(int productId, int colorId) {
        String sql = "SELECT id from cart_item where product_id = ? and color_id = ?";
       try {
        int count = jdbcTemplate.queryForObject(sql, Integer.class, productId, colorId);
        return count > 0; }
       catch (EmptyResultDataAccessException e) {
           return false;
       }

    }
    @Override
    public int deleteFromCart(String modelName) {
        String sql = "DELETE FROM cart_item where model = ?";
        return jdbcTemplate.update(sql, modelName);
        }
    }


