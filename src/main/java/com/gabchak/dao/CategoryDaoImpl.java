package com.gabchak.dao;

import com.gabchak.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT CATEGORY_NAME FROM CATEGORIES WHERE ID = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Category.class)));

    }

    @Override
    public Optional<Category> findByIdWithProductList(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT C.CATEGORY_NAME, P.ID, P.NAME, P.PRICE, P.DESCRIPTION " +
                        "FROM CATEGORIES C JOIN PRODUCTS P " +
                        "ON C.ID = P.FK_CATEGORIES " +
                        "WHERE C.ID = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Category.class)));
    }

    @Override
    public Optional<Category> findByName(String name) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT ID, CATEGORY_NAME FROM CATEGORIES WHERE CATEGORY_NAME = ?",
                new Object[]{name}, new BeanPropertyRowMapper<>(Category.class)));
    }

    @Override
    public Optional<List<Category>> findAll() {
        return Optional.ofNullable(jdbcTemplate.query("SELECT ID, CATEGORY_NAME FROM CATEGORIES",
                (rs, rowNum) -> new Category(
                        rs.getLong("ID"),
                        rs.getString("CATEGORY_NAME")
                )));
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM CATEGORIES WHERE ID = ?", id);
    }
}
