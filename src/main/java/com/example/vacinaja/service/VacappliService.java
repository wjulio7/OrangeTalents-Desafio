package com.example.vacinaja.service;


import com.example.vacinaja.model.VacAppli;

public interface VacappliService {

    VacAppli save(VacAppli vacappli);
    VacAppli findByUser_id(Long user_id);

}
