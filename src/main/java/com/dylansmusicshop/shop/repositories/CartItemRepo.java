package com.dylansmusicshop.shop.repositories;

import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo {

    List<String> FindModelByID(int id);

    CartItem addToCart(CartItem cartItem);

    List<CartItem> showCart();

    int deleteFromCart(String modelName);
}

