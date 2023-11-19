package com.dylansmusicshop.userAdmin;

import com.dylansmusicshop.products.Products;
import org.springframework.stereotype.Repository;


public interface AdminRepository {

    void addProductToDataBase(String brandName ,String modelName, int productType, double price);
}
