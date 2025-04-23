// En interfaces.persistence
package com.example.interfaces.persistence;

import com.example.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}