package com.neoteric.doubleSchema.service;

import com.neoteric.doubleSchema.product.Product;
import com.neoteric.doubleSchema.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void adding(Product product) {
        productRepository.save(product);
    }
}
