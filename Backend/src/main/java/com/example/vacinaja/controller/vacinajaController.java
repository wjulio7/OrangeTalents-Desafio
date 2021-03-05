package com.example.vacinaja.controller;

import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.service.vacappliService;
import com.example.vacinaja.service.vacinajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class vacinajaController {
     @Autowired
     vacinajaService vacinajaservice;
    @Autowired
    vacappliService va;

    @PostMapping(value = "/userregister", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> userRegister(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){

            return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
        }


        vacinajaservice.save(user);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PostMapping(value = "/vacapplication/{user_id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> vacApplication(@PathVariable("user_id") long user_id, @RequestBody VacAppli vacAppli,    BindingResult result) {

        System.out.println("EU NAO ROUBO NINGUEM HEEEY HEY HEEE EU NAO ROUBO NINGUEM HEEEY HEY HEEE EU NAO ROUBO NINGUEM HEEEY HEY HEEE");
        System.out.println(vacAppli);
        System.out.println("EU NAO ROUBO NINGUEM HEEEY HEY HEEE EU NAO ROUBO NINGUEM HEEEY HEY HEEE EU NAO ROUBO NINGUEM HEEEY HEY HEEE");
       // int a  = vacAppli.get
       //va.save(vacAppli);


        User user = vacinajaservice.findById(user_id);
        vacAppli.setUser(user);
        va.save(vacAppli);

        return new ResponseEntity<>( HttpStatus.CREATED);
    }


}

