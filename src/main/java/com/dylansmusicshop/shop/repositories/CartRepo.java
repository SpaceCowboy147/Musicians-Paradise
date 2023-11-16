package com.dylansmusicshop.shop.repositories;


import com.dylansmusicshop.shop.entity.CartItem;

public interface CartRepo {

   int saveUserWithCartId(int userID);

   boolean UserIdExistsWithCartId(int userId);

   int getUserCartId(int username);



}