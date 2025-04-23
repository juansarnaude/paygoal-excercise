package com.example.services;

import com.example.interfaces.persistence.ProductRepository;
import com.example.interfaces.services.ProductService;
import com.example.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productFoundById = repository.findById(id);
        if (productFoundById.isEmpty()) {
            throw new IllegalArgumentException("Product with ID " + id + " was not found.");
        }

        Product toUpdate = productFoundById.get();
        toUpdate.setName(product.getName());
        toUpdate.setDescription(product.getDescription());
        toUpdate.setPrice(product.getPrice());
        toUpdate.setQuantity(product.getQuantity());
        return repository.save(toUpdate);
    }

    @Override
    public Product findProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found"));
    }

    @Override
    public Product findProductByName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name (cannot be null or empty)");
        }
        Product product = repository.findByName(name);
        if (product == null) {
            throw new IllegalArgumentException("Product with name " + name + " not found");
        }
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> findAllProductsOrderedByPrice() {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Product with ID " + id + " not found");
        }
        repository.deleteById(id);
    }
}