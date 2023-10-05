package com.dylansmusicshop.shop.repositories;

import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo {


    CartItem addToCart(CartItem cartItem);

    CartItem showCart();
}

