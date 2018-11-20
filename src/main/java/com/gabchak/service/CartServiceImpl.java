package com.gabchak.service;

import com.gabchak.dao.CartDao;
import com.gabchak.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private CartDao cartDao;

    @Autowired
    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public void addToCart(Long userId, Long productId, Integer quantity) {
        cartDao.addToCart(userId, productId, quantity);
    }

    @Override
    public Map<Product, Integer> findAllUsersProducts(Long userId) {
        return cartDao.findAllUsersProducts(userId);
    }

    @Override
    public void deleteProductById(Long userId, Long productId) {
        cartDao.deleteProductById(userId, productId);
    }
}
