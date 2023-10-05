package com.dylansmusicshop.shop.repositories;

import com.dylansmusicshop.shop.entity.CartItem;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepo {


   CartItem showItemsInCart();

}