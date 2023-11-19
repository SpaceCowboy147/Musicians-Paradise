package com.dylansmusicshop.shop.repositories;

import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CartItemRepo {

    String FindModelByID(int productId);

    CartItem addToCart(CartItem cartItem);
    public boolean isProductInCart( int productId, int colorId, int cardId);
    CartItem updateCart(CartItem cartItem);

    List<CartItem> getAllFromCart(int userID);


    int deleteFromCart(int quantity, int cartItemId);
    String getColorNameByCartId(int cartId);


    int getCartItemId(int userId, int productId, int colorId);
}

