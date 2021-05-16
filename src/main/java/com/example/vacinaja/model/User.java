package com.example.vacinaja.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
   // @Column(unique = true, nullable = false)
    private String username;

    @Email
    @NotBlank
    //@Column(unique = true)
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    @CPF
    @NotBlank
    //@Column(unique = true)
    private String cpf;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private boolean enabled;

    @OneToMany
    private List<VacAppli> vacappli;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;








}
