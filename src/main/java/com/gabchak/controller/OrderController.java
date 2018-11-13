package com.gabchak.controller;

import com.gabchak.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
