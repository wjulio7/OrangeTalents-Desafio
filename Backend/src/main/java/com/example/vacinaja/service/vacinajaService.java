package com.example.vacinaja.service;

import com.example.vacinaja.model.User;

public interface vacinajaService  {

    User save(User user);
   // User findById(long id);
     User findById(Long id);
}
