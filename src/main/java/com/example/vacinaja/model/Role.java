package com.example.vacinaja.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DOCTOR,
    ROLE_PATIENT;

    public String getAuthority() {
        return name();
    }
}
