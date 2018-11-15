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
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/admin/orders/delete_{id}")
    public ModelAndView deleteOrder(@PathVariable Long id, ModelAndView vm) {
        orderService.delete(id);
        vm.setViewName("OrdersList");
        vm.addObject("orders", orderService.findAll());
        return vm;
    }

    @PostMapping("/buy_{id}")
    public ModelAndView addToCart(@PathVariable Long id, HttpServletRequest request, Product product, Integer quantity, ModelAndView vm) {

        User user = findUserByCookies(request);
        Order order = orderService.findOpenOrderByUser(user);

        if (order == null) {
            order = new Order();
            order.setCustomer(user);
            order.setStatus(false);
            order.setOrderAmount(product.getPrice());
            order.increaseQuantity(product.getId(), quantity);
            orderService.create(order);
        } else {
            order.addProduct(product);
            order.setOrderAmount(order.getOrderAmount() + product.getPrice());
            order.increaseQuantity(product.getId(), quantity);
            orderService.update(order);
        }

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

    private User findUserByCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        String token = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("MATE")) {
                    token = cookie.getValue();
                }
            }
        }

        return token != null ? userService.findByToken(token) : null;
    }
}
