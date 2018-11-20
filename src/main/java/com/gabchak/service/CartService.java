package com.gabchak.service;

import com.gabchak.model.Product;

import java.util.Map;

public interface CartService {

    void addToCart(Long userId, Long productId, Integer quantity);

    Map<Product, Integer> findAllUsersProducts(Long userId);

    void deleteProductById(Long userId, Long productId);
}
