package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.JdbcProducts;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.service.CartItemService;
import com.dylansmusicshop.users.JdbcUser;
import com.dylansmusicshop.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CartControllers {

    private final JdbcUser userService;
    private final CartItemService cartItemService;

    @Autowired
    private JdbcProducts jdbcProducts;


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
        model.addAttribute("cart_item", cartProducts);

        return "cart";
    }
}
