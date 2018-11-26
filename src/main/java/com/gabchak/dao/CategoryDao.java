package com.gabchak.dao;

import com.gabchak.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findById(Long id);

    void deleteById(Long id);
}
