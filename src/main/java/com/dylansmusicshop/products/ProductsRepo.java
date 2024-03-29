package com.dylansmusicshop.products;

import java.util.List;

public interface ProductsRepo {

     Products findProductByID(int id);

    Products findByBrandName(String brand);

    public List<Products> findAllProducts();

    Products findByProductType();

    int findProductIDByName(String productName);

    double getProductPrice(String modelName);

    int getColorIdByColor(String color);

    int getCartIdByUsername(String username);
   String getColorNameByCartId(int cartId);

    List<Products> getGuitars(int itemTypeId);
}