package com.gabchak.dao;

import com.gabchak.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO USERS (EMAIL, TOKEN, PASSWORD, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?, ?, ?)",
                user.getEmail(),
                user.getToken(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT ID, EMAIL, TOKEN, PASSWORD, FIRST_NAME, LAST_NAME FROM USERS WHERE EMAIL = ?",
                new Object[] {email}, new BeanPropertyRowMapper<>(User.class)));
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE USERS SET EMAIL = ?, PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ?, TOKEN = ? WHERE ID = ?",
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getToken(),
                user.getId());
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, TOKEN FROM USERS WHERE ID = ?",
                new Object[] {id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Optional<User> findByToken(String token) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, TOKEN FROM USERS WHERE TOKEN = ?",
                new Object[] {token}, new BeanPropertyRowMapper<>(User.class)));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT ID, EMAIL, PASSWORD, TOKEN, FIRST_NAME, LAST_NAME FROM USERS",
                (rs, rowNum) -> new User(
                        rs.getLong("ID"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("TOKEN"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME")
                ));
    }

}
