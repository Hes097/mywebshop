package com.mywebshop.product_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class ProductRequest {

    @NotNull(message = "Name can not be empty")
    private String name;

    @NotNull(message = "Description can not be empty")
    private String description;

    @NotNull(message = "Price can not be null")
    @Min(value = 0, message = "Price must be 0 or higher")
    private Double price;

    @NotNull(message = "Stock can not be null")
    @Min(value = 0, message = "Stock must be 0 or higher")
    private Integer stock;

    // Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
