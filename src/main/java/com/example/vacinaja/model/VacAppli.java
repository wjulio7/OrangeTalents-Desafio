package com.example.vacinaja.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class VacAppli {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String vacname;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate applidate;

    @Email
    @NotBlank
    private String email;

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

    public LocalDate getApplidate() {
        return applidate;
    }

    public void setApplidate(LocalDate applidate) {
        this.applidate = applidate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
