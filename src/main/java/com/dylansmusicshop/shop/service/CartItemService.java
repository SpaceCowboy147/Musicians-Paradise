package com.dylansmusicshop.shop.service;

import com.dylansmusicshop.shop.RowMappers.CartItemRowMapper;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public String FindModelByID(int productId) {
        String sql = "SELECT products.model FROM cart_item JOIN products ON cart_item.product_id = products.id  WHERE cart_item.id = ?";

        return jdbcTemplate.queryForObject(sql, String.class, productId);

    }

    @Override
    public CartItem addToCart(CartItem cartItem) {
        String sql = "INSERT INTO cart_item(product_id, cart_id, price, quantity, color_id) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cartItem.getProductId(), cartItem.getCart_id(), cartItem.getPrice(), cartItem.getQuantity(), cartItem.getColorId());
        String selectSql = "SELECT * FROM cart_item WHERE product_id = ?"; //TODO needs to be cart_item id but works without
        return jdbcTemplate.queryForObject(sql, new Object[]{cartItem.getProductId()}, new CartItemRowMapper());
    }

    @Override
    public CartItem updateCart(CartItem cartItem) {
        String sql = "UPDATE cart_item SET price = price + ?, quantity = quantity + ? where product_id = ?";
        jdbcTemplate.update(sql, cartItem.getPrice(), cartItem.getQuantity(), cartItem.getProductId());
        return cartItem;
    }

    @Override
    public List<CartItem> getAllFromCart(int userID) {

        String sql = "SELECT p.model, color_name, c.color_id, c.quantity, c.price, c.id, c.product_id, c.cart_id\n" +
                "FROM cart_item c\n" +
                "JOIN products p ON c.product_id = p.id\n" +
                "JOIN cart ca ON c.cart_id = ca.id\n" +
                "JOIN color co ON c.color_id = co.id\n" +
                "WHERE ca.customer_id = ?";
        return jdbcTemplate.query(sql, new CartItemRowMapper(), userID);
    }

    public boolean isProductInCart(int productId, int colorId, int cartId) {
        String sql = "SELECT id from cart_item where product_id = ? and color_id = ?  and cart_id = 34";
        try {
            int count = jdbcTemplate.queryForObject(sql, Integer.class, productId, colorId);
            return count > 0;
        } catch (EmptyResultDataAccessException e) {   //TODO theres a bug that wont add to cart if something is
            //already in cart if i dont have this.

            return false;
        }

    }

    @Override
    public int deleteFromCart(int quantity, int cartItemId) { //TODO
        String sql = "UPDATE cart_item SET quantity = quantity - ? where id = ?;";
        return jdbcTemplate.update(sql, quantity, cartItemId);

    }

    public String getColorNameByCartId(int cartId) {
        String sql = "select c.color_name from cart_item ci\n" +
                "join color c on ci.color_id = c.id where ci.id = ?\n";
        return jdbcTemplate.queryForObject(sql, new Object[]{cartId}, String.class);
    }

    public double getTotalPrice(int cartId) {
        String sql = "SELECT SUM(price) FROM cart_item where cart_id = ?;";
        Double totalPrice = jdbcTemplate.queryForObject(sql, Double.class, cartId);

        return totalPrice != null ? totalPrice : 0;
    }

    @Override
    public int getCartItemId(int cartId,int productId, int colorId) {
        String sql = "SELECT id \n" +
                     "FROM cart_item \n" +
                     "WHERE  cart_id = ? AND product_id = ? AND color_id = ?;";
        return jdbcTemplate.queryForObject(sql, Integer.class,  cartId, productId, colorId);
    }

}

