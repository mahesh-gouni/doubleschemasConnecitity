package com.neoteric.doubleSchema.repository.product;

import com.neoteric.doubleSchema.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}