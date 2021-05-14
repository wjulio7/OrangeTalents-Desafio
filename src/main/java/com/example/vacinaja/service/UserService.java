package com.example.vacinaja.service;

import com.example.vacinaja.model.User;

public interface UserService {

    String save(User user);
    User findById(Long id);
    User findByUsername(String username);
}
