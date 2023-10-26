package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.ProductService;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.service.CartItemService;
import com.dylansmusicshop.users.JdbcUser;
import com.dylansmusicshop.users.User;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartControllers {

    private final JdbcUser userService;
    private final CartItemService cartItemService;

    @Autowired
    private ProductService productService;


    @Autowired
    public CartControllers(JdbcUser userService, CartItemService cartItemService) {
        this.userService = userService;
        this.cartItemService = cartItemService;

    }


    @GetMapping("/cart")
    public String showCart(Model model, Principal principal) {

        String username = principal.getName();
        User user = userService.findByUsername(username);

        List<CartItem> productsInUserCart = cartItemService.getAllFromCart(user.getID());
      //  Map<CartItem, String> combinedList = new HashMap<>();
        Map<CartItem, Pair<String, String>> combinedMap = new HashMap<>();


        for(CartItem cartItem : productsInUserCart) {
              int cartId = cartItem.getId();
              int productId = cartItem.getProductId();
              String modelName = cartItemService.FindModelByID(cartId);
              String colorName = productService.getColorNameByCartId(productId);
            combinedMap.put(cartItem, Pair.of(modelName, colorName));
            //combinedList.put(cartItem, colorName );
        }
       model.addAttribute("combinedList", combinedMap);

            return "cart";
        }

    }
