package com.example.vacinaja.controller;

import com.example.vacinaja.factory.StrategyFactory;
import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.service.VacappliService;
import com.example.vacinaja.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class vacinajaController {

    private final UserService userService;

    private final VacappliService vacappliService;

    private final StrategyFactory strategyFactory;

    @PostMapping(value = "/users/signup", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> userRegister(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(OK).body(userService.save(user));
    }

    @PostMapping("/users/signin")
    ResponseEntity<String> login(//
                        @ApiParam("username") @RequestParam String username, //
                        @ApiParam("password") @RequestParam String password) {
        return ResponseEntity.ok(userService.signin(username, password));
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
    ResponseEntity<?> teste() {
        LocalDate data = LocalDate.of(2019, 4, 1);

        return ResponseEntity.ok(strategyFactory.findStrategyByType("StrategyICMS").getGenericResponse(data));
    }

    @GetMapping("/users/s2/{user_id}")
    ResponseEntity<?> teste2(@PathVariable("user_id") long user_id) {
        VacAppli vacAppli = vacappliService.findByUser_id(user_id);

       // return ResponseEntity.status(OK).body(vacAppli.getApplidate());
        return ResponseEntity.ok(strategyFactory.findStrategyByType("StrategyASTRAZENECA").getGenericResponse(vacAppli.getApplidate()));
        //User user = userService.findById(user_id);
        //LocalDate data = LocalDate.of(2019, 4, 1);
        //return ResponseEntity.ok(strategyFactory.findStrategyByType("StrategyICMS").getGenericResponse(data));

    }

}

