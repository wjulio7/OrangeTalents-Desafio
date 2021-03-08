package com.example.vacinaja.repository;


import com.example.vacinaja.model.VacAppli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vacApplicationRepository extends JpaRepository<VacAppli, Long> {

}
