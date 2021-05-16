package com.example.vacinaja.repository;


import com.example.vacinaja.model.VacAppli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacApplicationRepository extends JpaRepository<VacAppli, Long> {
    VacAppli findByUser_id(Long user_id);
}
