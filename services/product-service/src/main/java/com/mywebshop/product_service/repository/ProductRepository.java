package com.mywebshop.product_service.repository;

import com.mywebshop.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Hier kann ich später eigene Abfragen definieren z. B. findByName(...)
}