package com.example.vacinaja.service;

import com.example.vacinaja.model.User;

public interface userService {

    User save(User user);
    User findById(Long id);
}
