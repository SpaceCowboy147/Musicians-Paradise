package com.dylansmusicshop.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class LoginPageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/shopHome")
    public String shopPage() {
        return "shopHome";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/login-error")
    public String loginErrorPage() {
        return "Incorrect username or password";
    }

}




