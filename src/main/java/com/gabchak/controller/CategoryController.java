package com.gabchak.controller;

import com.gabchak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public ModelAndView showAllCategories() {
        ModelAndView vm = new ModelAndView();

        vm.setViewName("categories");
        vm.addObject("categories", categoryService.findAll());

        return vm;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public ModelAndView showCategoryPage(@PathVariable Long id) {
        ModelAndView vm = new ModelAndView();

        vm.setViewName("category");
        vm.addObject("category", categoryService.findById(id));

        return vm;
    }


    //TODO: page create category
    //TODO: page edit category
}
