package com.gabchak.model;

import java.util.Calendar;
import java.util.List;

public class Order {

    private Long orderId;
    private User customer;
    private Calendar orderDate;
    private String orderComment;
    private Double orderAmount;
    private List<Product> products;
    private Integer quantity;

    public Order() {
    }

    public Order(Long orderId, User customer, Calendar orderDate, String orderComment, Double orderAmount, List<Product> products, Integer quantity) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderComment = orderComment;
        this.orderAmount = orderAmount;
        this.products = products;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
