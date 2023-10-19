package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.Products;
import com.dylansmusicshop.products.productService;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.service.CartItemService;
import com.dylansmusicshop.users.JdbcUser;
import com.dylansmusicshop.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartControllers {

    private final JdbcUser userService;
    private final CartItemService cartItemService;

    @Autowired
    private productService productService;


    @Autowired
    public CartControllers(JdbcUser userService, CartItemService cartItemService) {
        this.userService = userService;
        this.cartItemService = cartItemService;

    }


    @GetMapping("/cart")
    public String showCart(Model model, Principal principal) {

        String username = principal.getName();
        User user = userService.findByUsername(username);

        List<CartItem> cartProducts = cartItemService.getAllFromCart(user.getID());
        Map<CartItem, String> combinedList = new HashMap<>();

        for(CartItem cartItem : cartProducts) {
            int productID = cartItem.getProductId();
            String productModel = cartItemService.FindModelByID(productID);
            combinedList.put(cartItem, productModel);

        }
        model.addAttribute("combinedList", combinedList);

            return "cart";
        }

    }
