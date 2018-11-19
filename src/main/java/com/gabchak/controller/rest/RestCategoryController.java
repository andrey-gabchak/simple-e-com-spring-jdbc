package com.gabchak.controller.rest;

import com.gabchak.controller.external.model.CategoryDto;
import com.gabchak.model.Category;
import com.gabchak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class RestCategoryController {

    private CategoryService categoryService;

    @Autowired
    public RestCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/rest/categories")
    public List<CategoryDto> getAll() {
        return categoryService.findAll().stream()
                .map(CategoryDto::of)
                .collect(toList());
    }
}
