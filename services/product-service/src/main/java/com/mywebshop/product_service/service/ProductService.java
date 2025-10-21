package com.mywebshop.product_service.service;

import com.mywebshop.product_service.model.Product;
import com.mywebshop.product_service.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mywebshop.product_service.dto.ProductRequest;
import com.mywebshop.product_service.dto.ProductResponse;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductResponse> getAllProducts() {
        return repo.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }


    public ProductResponse getProductById(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToResponse(product);
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setDescription(request.getDescription());

        Product saved = repo.save(product);
        return mapToResponse(saved);
    }

    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setDescription(product.getDescription());
        return response;
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = findProductEntityById(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setDescription(request.getDescription());

        Product updated = repo.save(product);
        return mapToResponse(updated);
    }

    @Transactional
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }

    private Product findProductEntityById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

}
