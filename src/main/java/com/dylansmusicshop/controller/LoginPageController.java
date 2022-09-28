package com.dylansmusicshop.controller;


import com.dylansmusicshop.users.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
    public class LoginPageController {

    @GetMapping("/login")
    //@RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/shopHome")
    public String coursesPage() {
        return "shopHome";
    }

}




