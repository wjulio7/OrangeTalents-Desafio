package com.example.vacinaja.controller;

import com.example.vacinaja.factory.StrategyFactory;
import com.example.vacinaja.model.VacAppli;
import com.example.vacinaja.service.VacappliService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/consultation")
@Controller
@AllArgsConstructor
public class VacConsultation {

    private final VacappliService vacappliService;
    private final StrategyFactory strategyFactory;

    @GetMapping("/coronavac/{user_id}")
    ResponseEntity<?> coronavac(@PathVariable("user_id") long user_id) {
        VacAppli vacAppli = vacappliService.findByUser_id(user_id);
         return ResponseEntity.ok(strategyFactory.findStrategyByType("StrategyCORONAVAC").getGenericResponse(vacAppli.getApplidate()));
    }

    @GetMapping("/pfizer/{user_id}")
    ResponseEntity<?> pfizer(@PathVariable("user_id") long user_id) {
        VacAppli vacAppli = vacappliService.findByUser_id(user_id);
        return ResponseEntity.ok(strategyFactory.findStrategyByType("StrategyPFIZER").getGenericResponse(vacAppli.getApplidate()));

    }
}
