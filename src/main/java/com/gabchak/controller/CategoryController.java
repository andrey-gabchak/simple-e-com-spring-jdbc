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

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public ModelAndView showAllCategories(ModelAndView vm) {

        vm.setViewName("categories");
        vm.addObject("categories", categoryService.findAll());

        return vm;
    }

    @RequestMapping(path = "/category_{id}", method = RequestMethod.GET)
    public ModelAndView findCategoryById(@PathVariable Long id, ModelAndView vm) {

        vm.setViewName("category");
        vm.addObject("category", categoryService.findByIdWithProductList(id));

        return vm;
    }

    @RequestMapping(path = "/{categoryName}", method = RequestMethod.GET)
    public ModelAndView findCategoryByName(@PathVariable String categoryName, ModelAndView vm) {
        Category category = categoryService.findByName(categoryName);
        vm.setViewName("category");
        vm.addObject("category", categoryService.findByIdWithProductList(category.getId()));

        return vm;
    }

    @GetMapping("/admin/categories/create_category")
    public String createCategoryPage() {
        return "categoryCreate";
    }

    @PostMapping("/admin/categories/create_category")
    public String createCategory(@PathVariable String categoryName) {
        categoryService.addCategory(new Category(categoryName));
        return "categoryAdminList";
    }

    @PostMapping("/admin/categories/{id}_delete")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "categoryAdminList";
    }
    //TODO: page edit category
}
