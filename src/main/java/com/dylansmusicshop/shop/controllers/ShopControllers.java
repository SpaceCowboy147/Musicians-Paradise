package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.ProductService;
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
    private ProductService productService;


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
                            @RequestParam("quantity") int quantity) {

        int productId = productService.findProductIDByName(productName);
        int colorId = productService.getColorIdByColor(color);
        try {
            if (cartItemService.isProductInCart(productId, colorId)) {
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
                Products products = new Products();
                products.setID(productId);
               products.setColor(colorId);
                CartItem cartItem = new CartItem();
                double itemPrice = productService.getProductPrice(productName);
                double priceTotal = itemPrice * quantity;
                cartItem.setProductId(products.getID());
                cartItem.setColorId(colorId);
                cartItem.setCart_id(1); //TODO ID based on user
                cartItem.setPrice(priceTotal);
                cartItem.setColorId(products.getColorId());
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

