package com.neoteric.doubleSchema.service;

import com.neoteric.doubleSchema.product.Product;
import com.neoteric.doubleSchema.user.User;
import com.neoteric.doubleSchema.repository.product.ProductRepository;
import com.neoteric.doubleSchema.repo.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public MyService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional("userTransactionManager")
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional("productTransactionManager")
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
