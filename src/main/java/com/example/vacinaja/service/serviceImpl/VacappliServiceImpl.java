package com.example.vacinaja.service.serviceImpl;


import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.repository.VacApplicationRepository;
import com.example.vacinaja.service.VacappliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacappliServiceImpl implements VacappliService {

    @Autowired
    VacApplicationRepository vacapplicationrepository;

    @Override
    public VacAppli save(VacAppli vacappli) {
        return vacapplicationrepository.save(vacappli);
    }

    @Override
    public VacAppli findByUser_id(Long user_id){
        return vacapplicationrepository.findByUser_id(user_id);
    }

}
