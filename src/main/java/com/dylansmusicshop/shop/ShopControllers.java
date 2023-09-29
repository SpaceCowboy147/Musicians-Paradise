package com.dylansmusicshop.shop;

import com.dylansmusicshop.products.JdbcProducts;
import com.dylansmusicshop.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShopControllers {
@Autowired
private JdbcProducts jdbcProducts;

    @GetMapping("/products")
    @ResponseBody
    public List<Products> productsPage() {
        return jdbcProducts.findAllProducts();
    }

    @GetMapping("/cart")
    public String viewCart() {
        return "cart";
    }

    @GetMapping("/account")
    public String viewAccountPage() {
        return "account";
    }

    @Autowired
    private JdbcProducts products;
}

