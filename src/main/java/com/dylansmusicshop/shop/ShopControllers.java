package com.dylansmusicshop.shop;

import org.springframework.web.bind.annotation.GetMapping;

public class ShopControllers {

    @GetMapping("/products")
    public String productsPage() {
        return "products";
    }

    @GetMapping("/cart")
    public String viewCart() {
        return "cart";
    }

    @GetMapping("/account")
    public String viewAccountPage() {
        return "account";
    }
}

