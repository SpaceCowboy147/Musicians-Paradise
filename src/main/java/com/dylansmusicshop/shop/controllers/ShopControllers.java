package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.JdbcProducts;
import com.dylansmusicshop.products.Products;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import com.dylansmusicshop.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopControllers {


    @Autowired
    private JdbcProducts jdbcProducts;


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
        return jdbcProducts.findAllProducts();

    }


    @PostMapping("/addToCart")
    @ResponseBody
    public String addToCart(@RequestParam("model") String productName,
                            @RequestParam("color") String color,
                            @RequestParam("quantity") int quantity) {

        int productId = jdbcProducts.findProductIDByName(productName);
        try {
            if (cartItemService.isProductInCart(productId)) {
                CartItem cartItem = new CartItem();
                double itemPrice = jdbcProducts.getProductPrice(productName);
                double priceTotal = itemPrice * quantity;

                cartItem.setProductId(productId);
                cartItem.setPrice(priceTotal);
                cartItem.setQuantity(quantity);
                cartItemService.updateCart(cartItem);

            } else {
                Products products = new Products();
                products.setID(productId);
                products.setColor(color); //TODO color implementation

                CartItem cartItem = new CartItem();
                double itemPrice = jdbcProducts.getProductPrice(productName);
                double priceTotal = itemPrice * quantity;
                cartItem.setProductId(products.getID());
                cartItem.setCart_id(1); //TODO ID based on user
                cartItem.setPrice(priceTotal);
                cartItem.setQuantity(quantity);
                cartItemService.addToCart(cartItem);

            }
            return "Added to cart";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        @GetMapping("/account")
        public String viewAccountPage () {
            return "account";
        }

    }

