package com.example.vacinaja.controller;

import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.service.vacappliService;
import com.example.vacinaja.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class vacinajaController {
     @Autowired
     userService us;
    @Autowired
    vacappliService va;

    @PostMapping(value = "/userregister", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> userRegister(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        us.save(user);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PostMapping(value = "/vacapplication/{user_id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> vacApplication(@PathVariable("user_id") long user_id, @RequestBody VacAppli vacAppli,   BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        User user = us.findById(user_id);
        vacAppli.setUser(user);
        va.save(vacAppli);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


}

