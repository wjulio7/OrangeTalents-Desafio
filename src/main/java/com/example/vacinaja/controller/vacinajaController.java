package com.example.vacinaja.controller;

import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.service.VacappliService;
import com.example.vacinaja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class vacinajaController {


    @Autowired
    UserService userService;

    @Autowired
    VacappliService vacappliService;

    @PostMapping(value = "/users/signup", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> userRegister(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(OK).body(userService.save(user));
    }

    @PostMapping(value = "/vacapplication/{user_id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> vacApplication(@PathVariable("user_id") long user_id, @RequestBody @Valid VacAppli vacAppli,   BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        User user = userService.findById(user_id);
        vacAppli.setUser(user);
        vacappliService.save(vacAppli);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("/users/s")
    ResponseEntity<String> teste() {
        LocalDate data = LocalDate.of(2019, 4, 3);
        data = data.plusDays(10);
        return ResponseEntity.status(OK).body(data.toString());
    }


}

