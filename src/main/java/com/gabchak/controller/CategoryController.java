package com.gabchak.controller;

import com.gabchak.model.Category;
import com.gabchak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ModelAndView getAllCategories(ModelAndView vm) {
        vm.setViewName("categories");
        vm.addObject("categories", categoryService.findAll());
        return vm;
    }

    @GetMapping("/admin/categories")
    public ModelAndView getAllCategoriesForAdmin(ModelAndView vm) {
        vm.setViewName("categoryAdminList");
        vm.addObject("categories", categoryService.findAll());
        return vm;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView getCategory(@RequestParam("c_id") Long id, ModelAndView vm) {
        Category category = categoryService.findById(id);
        vm.setViewName("category");
        vm.addObject("category", category);
        return vm;
    }

    @PostMapping("/admin/categories/{categoryId}_delete")
    public ModelAndView deleteCategoryById(@PathVariable Long categoryId, ModelAndView vm) {
        categoryService.deleteById(categoryId);
        vm.setViewName("categoryAdminList");
        vm.addObject("categories", categoryService.findAll());
        return vm;
    }
}
