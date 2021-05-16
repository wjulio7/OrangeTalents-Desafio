package com.example.vacinaja.controller;

import com.example.vacinaja.service.UserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/delete")
@Controller
@AllArgsConstructor
public class DeleteUserController {

    private final UserService userService;

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    ResponseEntity<?> delete(@ApiParam("username") @PathVariable String username) {
       return ResponseEntity.status(OK).body( userService.delete(username));

    }
}
