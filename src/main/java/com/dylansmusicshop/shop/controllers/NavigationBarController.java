package com.dylansmusicshop.shop.controllers;

import com.dylansmusicshop.products.ProductService;
import com.dylansmusicshop.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NavigationBarController {
    @Autowired
    ProductService productService;

    @GetMapping("/account")
    public String viewAccountPage () {
        return "account";
    }


    @GetMapping("/guitars")
    public String showGuitarProducts(Model model) {
        List<Products> guitars = productService.getGuitars(1);
        model.addAttribute("guitars", guitars);
        return "products/guitars";

    }
    @GetMapping("/drums")
    public String showDrumProducts(Model model) {

        List<Products> drums = productService.getGuitars(5);
        model.addAttribute("drums", drums);
        return "products/drums";
    }
    @GetMapping("/accessories")
    public String showAccessoryProducts(Model model) {
        List<Products> accessories = productService.getGuitars(7);
        model.addAttribute("accessories", accessories);
        return "products/accessories";
    }
}
