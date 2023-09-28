package com.dylansmusicshop.products;

import com.dylansmusicshop.users.User;
import com.dylansmusicshop.users.UserRowMapper;

import java.util.List;

public interface productsRepo {

     Products findProductByID(int id);

    Products findByBrandName(String brand);

    public List<Products> findAllProducts();


}