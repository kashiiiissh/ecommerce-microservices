package com.ecommerce.product.controller;

import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}/exists")
    public Boolean isProductExists(@PathVariable Long id){
        return productService.isProductExists(id);
    }
}