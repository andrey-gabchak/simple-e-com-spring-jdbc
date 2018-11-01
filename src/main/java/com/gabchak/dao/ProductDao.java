package com.gabchak.dao;

import com.gabchak.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    void addProduct(Product product);

    Optional<Product> findById(Long id);

    void update(Product product);

    void deleteById(Long id);

    Optional<List<Product>> findAll();
}
