package com.dylansmusicshop.userAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
AdminRepository adminRepository;

    @PostMapping("/addProductToDataBase")
    public void addProductToDataBase(@RequestParam("brandName") String brandName,
                                     @RequestParam ("modelName") String modelName,
                                     @RequestParam ("productType") int productType,
                                     @RequestParam("price")  double price) {

            adminRepository.addProductToDataBase(brandName, modelName, productType, price);
    }
}
