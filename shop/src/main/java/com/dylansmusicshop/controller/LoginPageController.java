package com.dylansmusicshop.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
    public class LoginPageController {

    @GetMapping("/login")
    //@RequestMapping("/login")
//    @ResponseBody
    public String loginPage() {
        return "login";

    }

        @GetMapping("/shopHome")
                public String coursesPage() {
            return "shopHome";
        }

        @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return modelAndView;
        }
        @GetMapping("/logout")
    public String logOutScreen() {
        return "logout";
        }

    }


