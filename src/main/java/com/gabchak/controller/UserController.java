package com.gabchak.controller;

import com.gabchak.model.User;
import com.gabchak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    private  UserService userService;

    @Autowired //Можно @Autowired писать над конструктором или над полем и тогда без конструктора.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(name = "user") User user) {
        ModelAndView vm = new ModelAndView();
        userService.getUserByEmail(user.getEmail());
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }
}
