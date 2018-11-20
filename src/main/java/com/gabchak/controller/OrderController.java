package com.gabchak.controller;

import com.gabchak.model.Order;
import com.gabchak.model.Product;
import com.gabchak.model.User;
import com.gabchak.service.OrderService;
import com.gabchak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    private OrderService orderService;

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

    @PostMapping("/cart/confirm")
    public ModelAndView confirmOrder(Order order, ModelAndView vm) {
        if (order == null) {
            vm.setViewName("errorEmptyOrder");
            return vm;
        }

        order.setStatus(true);
        orderService.update(order);

        vm.setViewName("thanksForOrder");
        return vm;
    }

    @GetMapping("/admin/orders")
    public ModelAndView showOrders(ModelAndView vm) {
        vm.setViewName("orders");
        vm.addObject("orders", orderService.findAll());
        return vm;
    }

    @GetMapping("/admin/orders/{id}")
    public ModelAndView showEditOrderPage(@PathVariable Long id, ModelAndView vm) {
        vm.setViewName("orderEdit");
        vm.addObject("order", orderService.findById(id));
        return vm;
    }

    @PostMapping("/admin/orders/save_{id}")
    public ModelAndView saveOrder(@PathVariable Long id, Order order, ModelAndView vm) {
        vm.setViewName("orders");
        orderService.update(order);
        vm.addObject("orders", orderService.findAll());
        return vm;
    }


}
