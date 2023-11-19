package com.dylansmusicshop.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @GetMapping("/guitars")
    public String showGuitarProducts() {
        return "guitars";

    }

    @GetMapping("/drums")
    public String showDrumProducts() {
        return "drums";
    }

    @GetMapping("/accessories")
    public String showAccessoryProducts() {
        return "accessories";
    }
}
