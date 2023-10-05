package com.dylansmusicshop.shop.repositories;

import com.dylansmusicshop.shop.entity.Cart;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepo {


   Cart showItemsInCart();

}