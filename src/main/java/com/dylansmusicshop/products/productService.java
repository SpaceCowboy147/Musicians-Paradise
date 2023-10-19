package com.dylansmusicshop.products;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productService implements ProductsRepo {
    private final JdbcTemplate jdbcTemplate;

    public productService(JdbcTemplate jdbcTemplate) {
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
}



