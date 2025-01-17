package com.neoteric.doubleSchema.controller;

import com.neoteric.doubleSchema.product.Product;
import com.neoteric.doubleSchema.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addingProduct(@RequestBody Product product){
        productService.adding(product);
    }
}
