package com.dylansmusicshop.userAdmin;

import com.dylansmusicshop.products.ProductRowMapper;
import com.dylansmusicshop.users.JdbcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminService implements AdminRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addProductToDataBase(String brandName, String modelName, int productType, double price) {
        String sql = "INSERT into products(brand, model, product_id, price) values (?,?,?,?)";
        jdbcTemplate.update(sql, brandName, modelName, productType, price);
    }

    @Override
    public String deleteProductFromDataBase(int productPrimaryId) {
        String sql = "DELETE FROM products where id = ?";
         jdbcTemplate.update(sql, productPrimaryId);
         return "Successfully deleted from database";
    }

}
