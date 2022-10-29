package com.dylansmusicshop.dao;

import com.dylansmusicshop.products.Products;

import java.util.List;

public interface productDAO {

    public List getAllProducts();
    public Products getProducts(int id);
    public void updateProducts(Products products);
    public void deleteProducts(Products products);
    }

