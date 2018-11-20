package com.gabchak.controller;

import com.gabchak.model.Product;
import com.gabchak.model.User;
import com.gabchak.service.CartService;
import com.gabchak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    private UserService userService;
    private CartService cartService;

    @Autowired
    public CartController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping("/buy")
    public ModelAndView addToCart(HttpServletRequest request, Product product, Integer quantity, ModelAndView vm) {


        User user = findUserByCookies(request);
        if (user != null) {
            cartService.addToCart(user.getId(), product.getId(), quantity);
            vm.setViewName("cart");
            vm.addObject("cart", cartService.findAllUsersProducts(user.getId()));
        } else {
            vm.setViewName("product");
        }

        return vm;
    }

    @GetMapping("/cart")
    public ModelAndView showCartPage(HttpServletRequest request, ModelAndView vm) {
        User user = findUserByCookies(request);

        vm.setViewName("cart");

        if (user != null) {
            vm.addObject("order", cartService.findAllUsersProducts(user.getId()));
        }

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
