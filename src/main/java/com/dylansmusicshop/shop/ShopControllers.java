package com.dylansmusicshop.shop;

import com.dylansmusicshop.products.JdbcProducts;
import com.dylansmusicshop.products.Products;
import com.dylansmusicshop.products.ProductsRepo;
import com.dylansmusicshop.shop.entity.Cart;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import com.dylansmusicshop.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopControllers {


    @Autowired
private JdbcProducts jdbcProducts;
    private  ProductsRepo productRepository;

    private  CartItemRepo cartItemRepository;
@Autowired
    private CartItemService cartItemService;
    JdbcTemplate jdbcTemplate;




    @GetMapping("/products")
    @ResponseBody
    public List<Products> productsPage() {
        return jdbcProducts.findAllProducts();
    }

    @GetMapping("/cart")
    @ResponseBody
    public List<CartItem> showCart() {
        return (List<CartItem>) cartItemService.showCart();
    }

    @PostMapping("/addToCart")
    @ResponseBody
    public String addToCart(@RequestParam("guitars") String productName,
                            @RequestParam("color") String color,
                            @RequestParam("quantity") int quantity) {
//
        Products products = new Products();

       products.setID(jdbcProducts.findProductIDByName(productName));
        products.setColor(color);
        CartItem cartItem = new CartItem();
        cartItem.setProductId(products.getID());
        cartItem.setPrice(products.getPrice());
        cartItem.setCart_id(19); //test
        cartItem.setQuantity(quantity);

        cartItemService.addToCart(cartItem);
return  "Added to cart";
    }

    @GetMapping("/account")
    public String viewAccountPage() {
        return "account";
    }

}

