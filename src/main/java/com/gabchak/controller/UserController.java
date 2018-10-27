package com.gabchak.controller;

import com.gabchak.controller.external.model.RegisterUserDto;
import com.gabchak.model.User;
import com.gabchak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) { //Spring вкладывает ViewModel
        vm.setViewName("register");
        vm.addObject("userDto", RegisterUserDto.empty());
        return vm;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView login(@Valid RegisterUserDto userDto, BindingResult bindingResult) {
        ModelAndView vm = new ModelAndView();
        if (bindingResult.hasErrors()) {
            vm.setViewName("register");
            vm.addObject("userDto", RegisterUserDto.empty());
            return vm;
        }
        User user = new User(userDto);
        userService.getUserByEmail(userDto.getEmail());
        vm.setViewName("home");
        vm.addObject("user", new User());
        return vm;
    }
}
