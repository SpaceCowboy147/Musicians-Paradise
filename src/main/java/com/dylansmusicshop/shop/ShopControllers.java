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

    private ProductsRepo productRepository;

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


    @GetMapping("/Cart")
    @ResponseBody
    public String showCart() {
     List<CartItem> cartItems = cartItemRepository.showCart();
           StringBuilder htmlDeleteItems = new StringBuilder("<table border='5'>");
           for (CartItem cartItem : cartItems) {
               htmlDeleteItems.append("<tr>");
               htmlDeleteItems.append("<tr>");
               htmlDeleteItems.append("<td>").append(cartItemService.FindModelByID(cartItem.getProductId())).append("</td>");
               htmlDeleteItems.append("<td>").append(cartItem.getPrice()).append("<button>delete</button></td>");
               htmlDeleteItems.append("</tr>");
           }
                return htmlDeleteItems.toString();
           }


    @PostMapping("/addToCart")
    @ResponseBody
    public String addToCart(@RequestParam("guitars") String productName,
                            @RequestParam("color") String color,
                            @RequestParam("quantity") int quantity) {
//
                Products products = new Products();
                int productId = jdbcProducts.findProductIDByName(productName);
                products.setID(productId);
                products.setColor(color);

                CartItem cartItem = new CartItem();
                double itemPrice = jdbcProducts.getProductPrice(productName);
                cartItem.setProductId(products.getID());
                cartItem.setCart_id(1);
                cartItem.setPrice(itemPrice);
                cartItem.setQuantity(quantity);
                cartItemService.addToCart(cartItem);

                return  "Added to cart";
    }

    @GetMapping("/account")
    public String viewAccountPage() {
        return "account";
    }

}

