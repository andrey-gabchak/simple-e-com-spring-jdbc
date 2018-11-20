package com.gabchak.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CartDaoImpl implements CartDao {

    private JdbcTemplate jdbcTemplate;
    private ProductDao productDao;

    @Autowired
    public CartDaoImpl(JdbcTemplate jdbcTemplate, ProductDao productDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.productDao = productDao;
    }

    @Override
    public void addToCart(Long userId, Long productId, Integer quantity) {
        jdbcTemplate.update("INSERT INTO CARTS (FK_USER_ID, FK_PRODUCT_ID, PRODUCT_QUANTITY) VALUES (?, ?, ?)",
                userId,
                productId,
                quantity);
    }

}
