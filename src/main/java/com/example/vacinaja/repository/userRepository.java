package com.example.vacinaja.repository;

import com.example.vacinaja.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {

}
