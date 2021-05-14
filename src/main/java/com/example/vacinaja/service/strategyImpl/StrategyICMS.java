package com.example.vacinaja.service.strategyImpl;


import com.example.vacinaja.enums.StrategyName;
import com.example.vacinaja.service.Strategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StrategyICMS implements Strategy {

    @Override
    public String getResponse() {
        return "I am instance of StrategyICMS";}

    @Override //São Paulo, cuja alíquota é de 18%
    public LocalDate getGenericResponse(LocalDate data) {
        return data.plusDays(14);
    }

    @Override
    public StrategyName init() {
        return StrategyName.StrategyICMS;
    }
}

