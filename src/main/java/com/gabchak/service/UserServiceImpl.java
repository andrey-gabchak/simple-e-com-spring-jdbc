package com.gabchak.service;

import com.gabchak.dao.UserDao;
import com.gabchak.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        String hashedPassword = hashPassword(user.getPassword());

        user.setToken(getToken());
        user.setPassword(hashedPassword);

        userDao.addUser(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public Optional<User> verifyPassword(User userByEmail, User user) {
        String hashedPassword = hashPassword(user.getPassword());

        return hashedPassword.equals(userByEmail.getPassword()) ? Optional.of(userByEmail) : Optional.empty();
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        byte[] encodedHash = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return bytesToHex(encodedHash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
