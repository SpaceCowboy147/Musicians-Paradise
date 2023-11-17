package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.ProductService;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartRepo;
import com.dylansmusicshop.shop.service.CartItemService;
import com.dylansmusicshop.users.JdbcUser;
import com.dylansmusicshop.users.User;
import com.dylansmusicshop.users.UserRepo;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartControllers {

    private final JdbcUser userService;
    private final CartItemService cartItemService;
    @Autowired
    public CartControllers(JdbcUser userService, CartItemService cartItemService) {
        this.userService = userService;
        this.cartItemService = cartItemService;

    }
    @Autowired
    private ProductService productService;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private UserRepo userRepository;

    @GetMapping("/cart")
    public String showCart(Model model, Principal principal) {

        String username = principal.getName();
        User user = userService.findByUsername(username);

        if (!cartRepo.UserIdExistsWithCartId(user.getID())) {
            cartRepo.saveUserWithCartId(user.getID());
        }

        List<CartItem> productsInUserCart = cartItemService.getAllFromCart(user.getID());
        Map<CartItem, Pair<String, String>> combinedMap = new HashMap<>();

        int userId = userRepository.findUserIdByUsername(username);
        double totalPrice = cartItemService.getTotalPrice(cartRepo.getUserCartId(userId));

        for(CartItem cartItem : productsInUserCart) {
              int cartId = cartItem.getId();
              String modelName = cartItemService.FindModelByID(cartId);
              String colorName = cartItemService.getColorNameByCartId(cartId);

            combinedMap.put(cartItem, Pair.of(modelName, colorName));

        }

        model.addAttribute("combinedList", combinedMap);
        model.addAttribute("totalPrice", totalPrice);

            return "cart";
        }
    @PostMapping("/deleteFromCart")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deleteProductFromCart(@RequestParam("quantity")int quantity,
                                      @RequestParam("productId") int productId,
                                      @RequestParam("colorId") int colorId,
                                        Principal principal) {

        String userName = principal.getName();
        int cartId = productService.getCartIdByUsername(userName);
        int cartItemId = cartItemService.getCartItemId(cartId, productId, colorId);
        System.out.println(cartItemId + " " + quantity);

        cartItemService.deleteFromCart(quantity, cartItemId);

        }

    }
