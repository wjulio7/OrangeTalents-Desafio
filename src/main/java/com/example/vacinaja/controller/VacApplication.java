package com.example.vacinaja.controller;

import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.service.UserService;
import com.example.vacinaja.service.VacappliService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/application")
public class VacApplication {

    private final VacappliService vacappliService;
    private final UserService userService;

    @PostMapping(value = "/{user_id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> vacApplication(@PathVariable("user_id") long user_id, @RequestBody @Valid VacAppli vacAppli, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        User user = userService.findById(user_id);
        vacAppli.setUser(user);
        vacappliService.save(vacAppli);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

}
