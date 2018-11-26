package com.gabchak.service;

import com.gabchak.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void deleteById(Long id);
}
