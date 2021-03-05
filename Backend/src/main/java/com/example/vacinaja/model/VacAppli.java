package com.example.vacinaja.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Entity
public class VacAppli {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String vacname;

    @NotBlank
    private String data;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(  User  user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacname() {
        return vacname;
    }

    public void setVacname(String vacname) {
        this.vacname = vacname;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
