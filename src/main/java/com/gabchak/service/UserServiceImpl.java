package com.gabchak.service;

import com.gabchak.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByEmail(String email) {
        System.out.println(email);
        return null;
    }
}
