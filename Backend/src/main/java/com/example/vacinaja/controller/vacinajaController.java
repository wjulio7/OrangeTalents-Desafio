package com.example.vacinaja.controller;

import com.example.vacinaja.model.User;
import com.example.vacinaja.service.vacinajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class vacinajaController {
     @Autowired
     vacinajaService vacinajaService;


    @PostMapping(value = "/userregister", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> userRegister(@RequestBody @Valid User user) {
        vacinajaService.save(user);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
