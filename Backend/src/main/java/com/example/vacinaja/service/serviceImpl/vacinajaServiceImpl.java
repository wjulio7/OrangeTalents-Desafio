package com.example.vacinaja.service.serviceImpl;

import com.example.vacinaja.model.User;
import com.example.vacinaja.repository.vacinajaRepository;
import com.example.vacinaja.service.vacinajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vacinajaServiceImpl implements vacinajaService {

    @Autowired
    vacinajaRepository vacinajarepository;

    @Override
    public User save(User user) {
        return vacinajarepository.save(user);
    }
}
