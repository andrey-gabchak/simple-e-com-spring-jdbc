package com.gabchak.dao;

import com.gabchak.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Order order) {
        jdbcTemplate.update(connection -> {
            PreparedStatement orderStatement = null;
            PreparedStatement productsStatement;
            try {
                orderStatement = connection
                        .prepareStatement("INSERT INTO ORDERS (CUSTOMER_ID, ORDER_DATE, ORDER_AMOUNT, ORDER_COMMENT) VALUES (?, ?, ?, ?);",
                                Statement.RETURN_GENERATED_KEYS);
                connection.setAutoCommit(false);
                orderStatement.setLong(1, order.getCustomer().getId());

                LocalDate localDate = LocalDateTime.now().toLocalDate();
                orderStatement.setDate(2, Date.valueOf(localDate));

                orderStatement.setDouble(3, order.getOrderAmount());
                orderStatement.setString(4, order.getOrderComment());

                orderStatement.executeUpdate();
                ResultSet generatedKeys = orderStatement.getGeneratedKeys();
                Long orderId = null;
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getLong("ORDER_ID");
                } else {
                    connection.rollback();
                }

                productsStatement = connection.prepareStatement(
                        "INSERT INTO ORDER_TO_PRODUCT (FK_ORDER_ID, FK_PRODUCT_ID, PRODUCT_QUANTITY) VALUES (?, ?, ?)");
                if (orderId != null) {
                    for (int i = 0; i < order.getProducts().size(); i++) {
                        productsStatement.setLong(1, orderId);
                        long productId = order.getProducts().get(i).getId();
                        productsStatement.setLong(2, productId);
                        productsStatement.setInt(3, order.getProductsQuantity().get(productId));
                    }
                }
                productsStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException el) {
                    el.printStackTrace();
                    throw new RuntimeException(el.getMessage());
                }
            }

            return orderStatement;
        });
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
