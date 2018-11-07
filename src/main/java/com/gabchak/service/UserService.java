package com.gabchak.service;

import com.gabchak.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);

    Optional<User> getUserByEmail(String email);

    Optional<User> verifyPassword(User userByEmail, User user);

    List<User> findAll();

    void update(User user);
}
