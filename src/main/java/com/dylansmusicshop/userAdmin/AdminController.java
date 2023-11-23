package com.dylansmusicshop.userAdmin;

import com.dylansmusicshop.products.ProductService;
import com.dylansmusicshop.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    ProductService productService;
    @Autowired
AdminRepository adminRepository;

    @PostMapping("/addProductToDataBase")
    public void addProductToDataBase(@RequestParam("brandName") String brandName,
                                     @RequestParam ("modelName") String modelName,
                                     @RequestParam ("productType") int productType,
                                     @RequestParam("price")  double price) {
            adminRepository.addProductToDataBase(brandName, modelName, productType, price);
    }

    @PostMapping("/admin/deleteProduct")
    public String deleteProductFromDataBase(@RequestParam("brandName") String brandName,
                                          @RequestParam ("modelName") String modelName) {
       adminRepository.deleteProductFromDataBase(brandName, modelName);

        return "Successfully deleted from database";



    }
}

