package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartControllers {
    private final CartItemService cartItemService;

    @Autowired
    public CartControllers(CartItemService cartItemService) {
        this.cartItemService = cartItemService;

    }


    @GetMapping("/cart")
    public String showCart(Model model) {

        List<CartItem> cartProducts = cartItemService.showCart(7);
        for (CartItem cartItem : cartProducts) {
            cartItemService.FindModelByID(cartItem.getProductId());
            model.addAttribute("cart_item", cartProducts);
        }

        return "cart";
    }
}