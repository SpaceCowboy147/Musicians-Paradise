package com.dylansmusicshop.products;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductService implements ProductsRepo {
    private final JdbcTemplate jdbcTemplate;

    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Products findProductByID(int id) {
        String sql = "SELECT * from products where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductRowMapper());
    }

    @Override
    public Products findByBrandName(String brand) {
        String sql = "SELECT * from products where brand = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{brand}, new ProductRowMapper());
    }

    @Override
    public List<Products> findAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public Products findByProductType() {
        String sql = "SELECT * FROM product_type where product_type = ?";
        return (Products) jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public int findProductIDByName(String productName) {
        String sql = "SELECT id from products where model = ?";
        Integer productId = jdbcTemplate.queryForObject(sql, new Object[]{productName}, Integer.class);
        return productId != null ? productId : 0;
    }

    @Override
    public double getProductPrice(String modelName) {
        String sql = "SELECT price FROM products where model = ?";
        Double productPrice = jdbcTemplate.queryForObject(sql, Double.class, modelName);
        return productPrice != null ? productPrice : 0;
    }

    @Override
    public int getColorIdByColor(String color) {
        String sql = "select id from color where color_name = ?";
        Integer colorId = jdbcTemplate.queryForObject(sql, Integer.class, color);
        return colorId != null ? colorId : 0;
    }

    @Override
    public int getCartIdByUsername(String username) {
        String sql =
                "SELECT c.id\n" +
                        "FROM cart c\n" +
                        "JOIN users u ON c.customer_id = u.id\n" +
                        "WHERE u.username = ?";
        Integer cartId = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return cartId != null ? cartId : 0;
    }


    @Override
    public String getColorNameByCartId(int cartId) {
        String sql = "select distinct c.color_name from cart_item ci\n" +
                "join color c on ci.color_id where ci.product_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cartId}, String.class);
    }
}





