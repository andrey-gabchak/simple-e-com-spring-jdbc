package com.gabchak.dao;

import com.gabchak.model.Order;
import com.gabchak.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class OrderDaoImpl implements OrderDao {

    private JdbcTemplate jdbcTemplate;
    private ProductDao productDao;
    private UserDao userDao;

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate, ProductDao productDao, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.productDao = productDao;
        this.userDao = userDao;
    }

    @Override
    public void create(Order order) {
        jdbcTemplate.update(connection -> {
            PreparedStatement orderStatement = null;
            PreparedStatement productsStatement;
            try {
                connection.setAutoCommit(false);
                orderStatement = connection
                        .prepareStatement("INSERT INTO ORDERS (CUSTOMER_ID, ORDER_DATE, ORDER_AMOUNT, ORDER_COMMENT) VALUES (?, ?, ?, ?);",
                                Statement.RETURN_GENERATED_KEYS);
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

                if (orderId != null) {
                    for (int i = 0; i < order.getProducts().size(); i++) {
                        productsStatement = connection.prepareStatement(
                                "INSERT INTO ORDER_TO_PRODUCT (FK_ORDER_ID, FK_PRODUCT_ID, PRODUCT_QUANTITY) VALUES (?, ?, ?)");
                        productsStatement.setLong(1, orderId);
                        long productId = order.getProducts().get(i).getId();
                        productsStatement.setLong(2, productId);
                        productsStatement.setInt(3, order.getProductsQuantity().get(productId));
                        productsStatement.executeUpdate();
                    }
                }
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
        jdbcTemplate.update(connection -> {
            PreparedStatement orderStatement = null;
            PreparedStatement orderToProductStatement;
            try {
                connection.setAutoCommit(false);

                orderStatement = connection.prepareStatement(
                        "UPDATE ORDERS SET CUSTOMER_ID = ?, ORDER_DATE = ?, ORDER_AMOUNT = ?, ORDER_COMMENT = ? WHERE ORDER_ID =?",
                        Statement.RETURN_GENERATED_KEYS);

                orderStatement.setLong(1, order.getCustomer().getId());
                orderStatement.setDate(2, Date.valueOf(order.getOrderDate()));
                orderStatement.setDouble(3, order.getOrderAmount());
                orderStatement.setString(4, order.getOrderComment());
                orderStatement.setLong(5, order.getOrderId());

                orderStatement.executeUpdate();

                ResultSet generatedKeys = orderStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    for (int i = 0; i < order.getProducts().size(); i++) {
                        orderToProductStatement = connection.prepareStatement(
                                "UPDATE ORDER_TO_PRODUCT SET FK_PRODUCT_ID = ?, PRODUCT_QUANTITY = ? WHERE FK_ORDER_ID = ?");
                        Long id = order.getProducts().get(i).getId();
                        orderToProductStatement.setLong(1, id);
                        orderToProductStatement.setInt(2, order.getProductsQuantity().get(id));
                        orderToProductStatement.setLong(3, order.getOrderId());
                        orderToProductStatement.executeUpdate();
                    }
                }

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
    public void delete(Long id) {
        jdbcTemplate.update(connection -> {
            PreparedStatement orderStatement = null;
            PreparedStatement orderToProductStatement;
            try {
                connection.setAutoCommit(false);

                orderToProductStatement = connection.prepareStatement(
                        "DELETE FROM ORDER_TO_PRODUCT WHERE FK_ORDER_ID = ?");
                orderToProductStatement.setLong(1, id);
                orderToProductStatement.executeUpdate();

                orderStatement = connection.prepareStatement(
                        "DELETE FROM ORDERS WHERE ORDER_ID = ?");
                orderStatement.setLong(1, id);
                orderStatement.executeUpdate();

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
    public Order findById(Long id) {

        Order order = jdbcTemplate.queryForObject(
                "SELECT ORDER_ID, CUSTOMER_ID, ORDER_DATE, ORDER_AMOUNT, ORDER_COMMENT FROM ORDERS WHERE ORDER_ID = ?",
                new Object[]{id}, (rs, rowNum) -> new Order(
                        rs.getLong("ORDER_ID"),
                        userDao.findById(rs.getLong("CUSTOMER_ID")),
                        rs.getDate("ORDER_DATE").toLocalDate(),
                        rs.getString("ORDER_COMMENT"),
                        rs.getDouble("ORDER_AMOUNT")
                ));

        if (order != null) {
            HashMap<Long, Integer> quantity = new HashMap<>();
            jdbcTemplate.query("SELECT FK_PRODUCT_ID, PRODUCT_QUANTITY FROM ORDER_TO_PRODUCT WHERE FK_ORDER_ID = ?",
                    new Object[]{id}, (rs, rowNum) -> quantity.put(
                            rs.getLong("FK_PRODUCT_ID"),
                            rs.getInt("PRODUCT_QUANTITY")
                    ));

            Set<Long> keys = quantity.keySet();
            List<Product> products = new ArrayList<>();
            for (Long key : keys) {
                products.add(productDao.findById(id));
            }

            order.setProductsQuantity(quantity);
            order.setProducts(products);
        }

        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
