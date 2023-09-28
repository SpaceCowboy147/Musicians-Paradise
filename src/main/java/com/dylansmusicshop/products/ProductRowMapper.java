package com.dylansmusicshop.products;

import com.dylansmusicshop.users.User;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Products> {
    @Override
    public Products mapRow(ResultSet resultSet, int rowNum) throws SQLException {
       Products product = new Products();
        product.setID(resultSet.getInt("id"));
        product.setModel("model");
        product.setBrand(resultSet.getString("brand"));
        product.setColor(resultSet.getString("color"));
        product.setPrice(resultSet.getDouble("price"));


        return product;
    }
}
