package com.gabchak.dao;

import com.gabchak.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

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


    @Override
    public Map<Product, Integer> findAllUsersProducts(Long userId) {
        Map<Product, Integer> quantity = new HashMap<>();

        jdbcTemplate.query("SELECT FK_PRODUCT_ID, PRODUCT_QUANTITY FROM CARTS WHERE FK_USER_ID = ?",
                new Object[] {userId}, (rs, rowNum) -> quantity.put(
                        productDao.findById(rs.getLong(1)),
                        rs.getInt(2)
                ));
        return quantity;
    }


}
