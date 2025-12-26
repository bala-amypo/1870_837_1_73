package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {

    User registerUser(User user, String roleName);

    boolean validatePassword(String raw, String encoded);

    Optional<User> findByUsername(String username);
}
