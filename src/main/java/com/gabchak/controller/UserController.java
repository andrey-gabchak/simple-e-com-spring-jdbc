package com.gabchak.controller;

import com.gabchak.controller.external.model.RegisterUserDto;
import com.gabchak.model.User;
import com.gabchak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {


    private  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView vm) {

        vm.setViewName("register");
        vm.addObject("userDto", RegisterUserDto.empty());
        return vm;
    }

    @PostMapping("/register")
    public String register(@Valid RegisterUserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = User.of(userDto);
        userService.addUser(user);

        return "home";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute(value = "user") User user, ModelAndView vm) {
        return userService.getUserByEmail(user.getEmail())
                .map(r -> userService.verifyPassword(r, user))
                .map(r -> {
                    vm.setViewName("home");
                    return vm;
                })
                .orElseGet(() -> {
                    vm.setViewName("login");
                    return vm;
                });
    }
}
