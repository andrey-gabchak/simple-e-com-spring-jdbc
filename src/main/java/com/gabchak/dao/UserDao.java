package com.gabchak.dao;

import com.gabchak.model.User;

import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    Optional<User> getByEmail(String email);

}
