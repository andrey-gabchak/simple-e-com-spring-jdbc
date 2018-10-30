package com.gabchak.dao;

import com.gabchak.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT ID, EMAIL, TOKEN, PASSWORD, FIRST_NAME, LAST_NAME FROM USERS WHERE EMAIL = ?",
                new Object[] {email}, new BeanPropertyRowMapper<>(User.class)));
        //new Object[] {email}, new BeanPropertyRowMapper<>(User.class) костыли, так нормально не работало
    }
}
