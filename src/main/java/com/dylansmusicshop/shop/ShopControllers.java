package com.dylansmusicshop.shop;

import com.dylansmusicshop.products.JdbcProducts;
import com.dylansmusicshop.products.Products;
import com.dylansmusicshop.products.ProductsRepo;
import com.dylansmusicshop.shop.entity.Cart;
import com.dylansmusicshop.shop.entity.CartItem;
import com.dylansmusicshop.shop.repositories.CartItemRepo;
import com.dylansmusicshop.shop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopControllers {

private JdbcProducts jdbcProducts;
    private  ProductsRepo productRepository;
    private  CartItemRepo cartItemRepository;
    private CartItemService cartItemService;




    @GetMapping("/products")
    @ResponseBody
    public List<Products> productsPage() {
        return jdbcProducts.findAllProducts();
    }

    @GetMapping("/cart")
    @ResponseBody
    public Cart viewCart() {
        return null;
    }

    @PostMapping("/addToCart")
    @ResponseBody
    public void addToCart(@RequestParam("product_id") String productId,
                          @RequestParam("quantity") int quantity,
                          @RequestParam("price") double price,
                          @RequestParam("cart_id") int cartID){


        Products products = new Products();
        products.getBrand(productId);
        products.getID();
        products.getPrice(price);


        CartItem cartItem = new CartItem();
        cartItem.setProductId(products.getID());
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);
        cartItemService.addToCart();

    }

    @GetMapping("/account")
    public String viewAccountPage() {
        return "account";
    }

}

