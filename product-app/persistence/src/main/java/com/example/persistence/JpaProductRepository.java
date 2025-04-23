package com.example.persistence;

import com.example.models.product.Product;
import com.example.interfaces.persistence.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends ProductRepository {
}