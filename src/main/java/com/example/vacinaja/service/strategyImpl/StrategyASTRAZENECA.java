package com.example.vacinaja.service.strategyImpl;


import com.example.vacinaja.enums.StrategyName;
import com.example.vacinaja.service.Strategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class StrategyASTRAZENECA implements Strategy {

    @Override
    public String getResponse() {
        return "I am instance of StrategyISS";    }

    @Override //Astrazeneca 90 dias
    public LocalDate getGenericResponse(LocalDate data) {
        return data.plusDays(90);
    }

    @Override
    public StrategyName init() {
        return StrategyName.StrategyASTRAZENECA;
    }
}
