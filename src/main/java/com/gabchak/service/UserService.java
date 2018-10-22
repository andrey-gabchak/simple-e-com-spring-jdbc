package com.gabchak.service;

import com.gabchak.model.User;

public interface UserService {

    User getUserByEmail(String email);
}
