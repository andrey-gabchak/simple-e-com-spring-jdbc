package com.gabchak.dao;

import com.gabchak.model.Category;
import com.gabchak.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCategory(Category category) {
        jdbcTemplate.update("INSERT INTO CATEGORIES (CATEGORY_NAME) VALUES (?)",
                category.getName());
    }

    @Override
    public void update(Category category) {
        jdbcTemplate.update("UPDATE CATEGORIES SET CATEGORY_NAME = ? WHERE ID = ?",
                category.getName(),
                category.getId());
    }

    @Override
    public Category findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT ID, CATEGORY_NAME FROM CATEGORIES WHERE ID = ?",
                new Object[]{id}, (rs, rowNum) -> new Category(
                        rs.getLong("ID"),
                        rs.getString("CATEGORY_NAME")
                ));

    }

    @Override
    public Category findByIdWithProductList(Long id) {
        List<Product> products = jdbcTemplate.query("SELECT ID, NAME, PRICE, DESCRIPTION, FK_CATEGORIES FROM PRODUCTS WHERE FK_CATEGORIES = ?",
                new Object[]{id}, (rs, rowNum) -> new Product(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getDouble("PRICE"),
                        rs.getString("DESCRIPTION"),
                        rs.getLong("FK_CATEGORIES")
                ));
        Category category = findById(id);
        if (category != null) {
            category.setProducts(products);
        }

        return category;

    }

    @Override
    public Category findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT ID, CATEGORY_NAME FROM CATEGORIES WHERE CATEGORY_NAME = ?",
                new Object[]{name}, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT ID, CATEGORY_NAME FROM CATEGORIES",
                (rs, rowNum) -> new Category(
                        rs.getLong("ID"),
                        rs.getString("CATEGORY_NAME")
                ));
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM CATEGORIES WHERE ID = ?", id);
    }
}
