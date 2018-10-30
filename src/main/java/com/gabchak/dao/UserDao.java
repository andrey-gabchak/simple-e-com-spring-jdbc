package com.gabchak.dao;

import com.gabchak.model.User;

import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    Optional<User> findByEmail(String email);

    void update(User user);

    Optional<User> findById(Long id);

    Optional<User> findByToken(String token);

}
