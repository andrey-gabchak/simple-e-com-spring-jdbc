package com.gabchak.model;

import java.util.Date;

public class Orders {

    private Long orderId;
    private User customerId;
    private Date orderDate;
    private String comment;
    private Long orderDetailsId;
    private Product product;
    private Integer quantity;

    public Orders() {
    }

    public Orders(Long orderId, User customerId, Date orderDate, String comment, Long orderDetailsId, Product product, Integer quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.comment = comment;
        this.orderDetailsId = orderDetailsId;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
