package com.dylansmusicshop.login;


import com.dylansmusicshop.products.JdbcProducts;
import com.dylansmusicshop.users.JdbcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
    public class LoginPageController {
@Autowired
private JdbcUser jdbcUser;
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
    public String shopPage() {

        return "shopHome";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "admin landing page";
    }

    @GetMapping("/login-error")
    public String loginErrorPage() {
        return "Incorrect username or password";
    }

}




