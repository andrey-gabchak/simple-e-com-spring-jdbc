package com.gabchak.service;

import com.gabchak.model.Order;

import java.util.List;

public interface OrderService {

    void create(Order order);

    void update(Order order);

    void delete(Long id);

    Order findById(Long id);

    List<Order> findAll();

}
