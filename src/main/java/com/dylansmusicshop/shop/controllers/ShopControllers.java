package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.ProductService;
import com.dylansmusicshop.products.Products;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import com.dylansmusicshop.shop.repositories.CartRepo;
import com.dylansmusicshop.shop.service.CartItemService;
import com.dylansmusicshop.users.JdbcUser;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class ShopControllers {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private JdbcUser userService;

    private final CartItemRepo cartItemRepository;

    @Autowired
    public ShopControllers(CartItemRepo cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Autowired
    private CartItemService cartItemService;
    JdbcTemplate jdbcTemplate;


    @GetMapping("/products")
    @ResponseBody
    public List<Products> productsPage() {
        return productService.findAllProducts();

    }


    @PostMapping("/addToCart")
    @ResponseBody
    public String addToCart(@RequestParam("model") String productName,
                            @RequestParam("color") String color,
                            @RequestParam("quantity") int quantity,
                            Principal principal) {

        int productId = productService.findProductIDByName(productName);
        int colorId = productService.getColorIdByColor(color);
        String userName = principal.getName();
        int cartId = productService.getCartIdByUsername(userName);

        try {

            if (cartItemService.isProductInCart(productId, colorId, cartId)) {
                CartItem cartItem = new CartItem();
                double itemPrice = productService.getProductPrice(productName);
                double priceTotal = itemPrice * quantity;
                cartItem.setProductId(productId);
                cartItem.setColorId(colorId);
                cartItem.setPrice(priceTotal);
                cartItem.setQuantity(quantity);
                cartItemService.updateCart(cartItem);
                return "Updated Cart";

            } else {


                CartItem cartItem = new CartItem();
                double itemPrice = productService.getProductPrice(productName);
                double priceTotal = itemPrice * quantity;
                cartItem.setProductId(productId);
                cartItem.setColorId(colorId);
                cartItem.setCart_id(cartId);
                cartItem.setPrice(priceTotal);
                cartItem.setQuantity(quantity);
                cartItemService.addToCart(cartItem);

            }
            return "Added to cart";

        } catch (
                EmptyResultDataAccessException e) { //TODO technically works but its getting multiple items and storing one so it throws this
            System.out.println("added to cart");
        }
        return "Added to cart";
    }
}

