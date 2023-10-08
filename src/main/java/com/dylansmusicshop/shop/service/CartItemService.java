package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.shop.RowMappers.CartItemRowMapper;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemService implements CartItemRepo {

    private final JdbcTemplate jdbcTemplate;
    public CartItemService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<String> FindModelByID(int id) {
        String sql = "SELECT products.model from cart_item join products on cart_item.product_id = products.id WHERE cart_item.product_id = ?";

        return jdbcTemplate.queryForList(sql, String.class, id);
    }

    @Override
    public CartItem addToCart(CartItem cartItem) {
        String sql = "INSERT INTO cart_item(product_id, cart_id, price, quantity) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cartItem.getProductId(),cartItem.getCart_id(), cartItem.getPrice(), cartItem.getQuantity());
        String selectSql = "SELECT * FROM cart_item WHERE product_id = ?";
        return jdbcTemplate.queryForObject(selectSql, new Object[]{cartItem.getProductId()}, new CartItemRowMapper());
    }

    @Override
    public List<CartItem> showCart() {
        String sql = "SELECT * FROM cart_item";
        return jdbcTemplate.query(sql, new CartItemRowMapper());
    }

    @Override
    public int deleteFromCart(String modelName) {
        String sql = "DELETE FROM cart_item where model = ?";
        return jdbcTemplate.update(sql, modelName);
        }
    }


