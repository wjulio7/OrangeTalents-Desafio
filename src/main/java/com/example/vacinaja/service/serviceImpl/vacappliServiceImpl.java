package com.example.vacinaja.service.serviceImpl;


import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.repository.vacApplicationRepository;
import com.example.vacinaja.service.VacappliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vacappliServiceImpl implements VacappliService {

    @Autowired
    vacApplicationRepository vacapplicationrepository;

    @Override
    public VacAppli save(VacAppli vacappli) {
        return vacapplicationrepository.save(vacappli);
    }

}
