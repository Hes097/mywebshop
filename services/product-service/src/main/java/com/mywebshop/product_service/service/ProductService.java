package com.mywebshop.product_service.service;

import com.mywebshop.product_service.model.Product;
import com.mywebshop.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Transactional
    public Product updateProduct(Long id, Product updated) {
        Product p = getProductById(id);
        p.setName(updated.getName());
        p.setDescription(updated.getDescription());
        p.setPrice(updated.getPrice());
        p.setStock(updated.getStock());
        return repo.save(p);
    }

    @Transactional
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
