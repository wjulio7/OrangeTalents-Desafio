package com.example.vacinaja.repository;

import com.example.vacinaja.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vacinajaRepository extends JpaRepository<User, Long> {
}
