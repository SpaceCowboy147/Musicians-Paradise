package com.dylansmusicshop.products;

import com.dylansmusicshop.users.User;
import org.springframework.jdbc.core.RowMapper;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Products>, Serializable {
    @Override
    public Products mapRow(ResultSet resultSet, int rowNum) throws SQLException {
       Products product = new Products();
        product.setID(resultSet.getInt("id"));
        product.setModel(resultSet.getString("model"));
        product.setBrand(resultSet.getString("brand"));
        product.setPrice(resultSet.getDouble("price"));


        return product;
    }
}
