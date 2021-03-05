package com.example.vacinaja.service.serviceImpl;

import com.example.vacinaja.model.User;
import com.example.vacinaja.repository.userRepository;
import com.example.vacinaja.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements userService {

    @Autowired
    userRepository vacinajarepository;

    @Override
    public User save(User user) {
        return vacinajarepository.save(user);
    }

   @Override
    public User findById(Long id) {

        Optional<User> user2 = vacinajarepository.findById(id);
        User user = user2.get();
        return user;
    }
}