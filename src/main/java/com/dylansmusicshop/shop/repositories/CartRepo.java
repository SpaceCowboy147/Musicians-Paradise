package com.dylansmusicshop.shop.repositories;


import com.dylansmusicshop.shop.entity.CartItem;

public interface CartRepo {


   CartItem showItemsInCart();

   int saveUserWithCartId(int userID);

   boolean UserIdExistsWithCartId(int userId);
}