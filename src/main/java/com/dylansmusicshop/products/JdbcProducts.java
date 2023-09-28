package com.dylansmusicshop.products;

import com.dylansmusicshop.users.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcProducts implements productsRepo {
   private final JdbcTemplate jdbcTemplate;
    public JdbcProducts(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Products findProductByID(int id) {
        String sql = "SELECT * from products where id = ?";
        return (Products) jdbcTemplate.query(sql,new Object[]{id}, new ProductRowMapper());
    }

    @Override
    public Products findByBrandName(String brand) {
        String sql = "SELECT * from products where brand = ?";
        return null;
    }

    @Override
    public List<Products> findAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }


}

