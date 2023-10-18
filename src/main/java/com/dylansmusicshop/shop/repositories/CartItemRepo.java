package com.dylansmusicshop.shop.repositories;

import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo {

    String FindModelByID(int productId);

    CartItem addToCart(CartItem cartItem);
    public boolean isProductInCart( int productId);
    CartItem updateCart(CartItem cartItem);

    List<CartItem> getAllFromCart(int userID);

    int deleteFromCart(String modelName);

}

