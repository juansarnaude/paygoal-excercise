package com.example.interfaces.services;

import com.example.models.product.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product findProductById(Long id);

    Product findProductByName(String name);

    List<Product> findAllProducts();

    List<Product> findAllProductsOrderedByPrice(boolean asc);

    void deleteProduct(Long id);
}