package com.gabchak.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> products = new HashMap<>();

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart() {
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, Integer quantity) {
        products.put(product, quantity);
    }
}
