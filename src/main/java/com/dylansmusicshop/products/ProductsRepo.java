package com.dylansmusicshop.products;

import java.util.List;

public interface ProductsRepo {

     Products findProductByID(int id);

    Products findByBrandName(String brand);

    public List<Products> findAllProducts();

    Products findByProductType();
}