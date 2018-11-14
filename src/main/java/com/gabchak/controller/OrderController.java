package com.gabchak.controller;

import com.gabchak.model.Order;
import com.gabchak.model.Product;
import com.gabchak.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;
    private Order order;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/admin/orders/delete_{id}")
    public ModelAndView deleteOrder(@PathVariable Long id, ModelAndView vm) {
        orderService.delete(id);
        vm.setViewName("OrdersList");
        vm.addObject("orders", orderService.findAll());
        return vm;
    }

    @PostMapping("/buy_{id}")
    public ModelAndView addToCart(@PathVariable Long id, Product product, ModelAndView vm) {
        if (order == null) {
            order = new Order();
        }
        order.addProduct(product);
        vm.setViewName("product");
        vm.addObject("order", order);
        return vm;
    }

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart";
    }

    @PostMapping("/cart/confirm")
    public ModelAndView confirmOrder(Order order, ModelAndView vm) {
        if (order == null) {
            vm.setViewName("errorEmptyOrder");
            return vm;
        }
        orderService.create(order);
        vm.setViewName("thanksForOrder");
        return vm;
    }

    @GetMapping("/admin/orders")
    public ModelAndView showOrders(ModelAndView vm) {
        vm.setViewName("orders");
        vm.addObject("orders", orderService.findAll());
        return vm;
    }
}
