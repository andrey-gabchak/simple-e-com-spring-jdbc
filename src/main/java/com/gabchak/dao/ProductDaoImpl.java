package com.gabchak.dao;

import com.gabchak.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addProduct(Product product) {
        jdbcTemplate.update("INSERT INTO PRODUCTS (NAME, PRICE, DESCRIPTION, FK_CATEGORIES) VALUES (?, ?, ?, ?)",
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT NAME, PRICE, DESCRIPTION, FK_CATEGORIES FROM PRODUCTS WHERE ID = ?",
                new Object[] {id}, new BeanPropertyRowMapper<>(Product.class)));
    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update("UPDATE PRODUCTS SET NAME = ?, PRICE = ?, DESCRIPTION = ?, FK_CATEGORIES = ? WHERE ID = ?",
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM PRODUCTS WHERE ID = ?", id);
    }

    @Override
    public Optional<List<Product>> findAll() {
        return Optional.ofNullable(jdbcTemplate.queryForList("SELECT ID, NAME, PRICE, DESCRIPTION, FK_CATEGORIES FROM PRODUCTS",
                Product.class));
    }
}
