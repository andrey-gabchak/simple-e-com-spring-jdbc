package com.gabchak.controller.external.model;

import com.gabchak.model.Product;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CategoryDto {

    @NotNull
    private String name;
    private Long id;
    private List<Product> products;

    private CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static CategoryDto empty() {
        return new CategoryDto();
    }
}
