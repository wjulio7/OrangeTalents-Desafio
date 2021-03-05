package com.example.vacinaja.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
}
