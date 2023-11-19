package com.dylansmusicshop.login;


import com.dylansmusicshop.products.ProductService;
import com.dylansmusicshop.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
    public class LoginPageController {
    private final ProductService productService;

    @Autowired
    LoginPageController(ProductService products) {
        this.productService = products;
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @GetMapping("/dashboard")
    public String redirectToDashboard(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("user"))) {
            return "redirect:/shopHome";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return "redirect:/admin";
        } else {
            throw new IllegalStateException("Unknown user role");
        }
    }



    @GetMapping("/shopHome")
    public String shopPage(Model model) {
        List<Products> products = productService.findAllProducts();
        model.addAttribute("shopHome", products);


        return "shopHome";
    }
    @GetMapping("/admin")
    public String showAdminPage(){
        return "admin";
    }


    @GetMapping("/login-error")
    public String loginErrorPage() {
        return "Incorrect username or password";
    }

}




